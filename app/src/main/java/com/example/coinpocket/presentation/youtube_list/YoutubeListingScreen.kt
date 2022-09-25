package com.example.coinpocket.presentation.youtube_list


import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.coinpocket.BuildConfig
import com.example.coinpocket.util.Routes
import com.example.coinpocket.R
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragmentXKt
import com.ramcosta.composedestinations.annotation.Destination


@Composable
@Destination(
    route = Routes.YoutubeList_NAV_GRAPH,
    start = true,
    navGraph = Routes.YoutubeList_NAV_GRAPH,
)
fun CompanyListingScreen(
    viewModel: CompanyListingsViewModel = hiltViewModel()
) {
    val allCompanies = viewModel.getAllCompanies.collectAsLazyPagingItems()

    Scaffold(
        content = {
            Column(modifier = Modifier.padding(18.dp)) {
            }
            YouTubeScreen("FHZ6bI3zb4M")

        }
    )

}

@Composable
fun YouTubeScreen(videoId:String) {
    val ctx = LocalContext.current
    AndroidView(
        factory = {
            val fm = (ctx as AppCompatActivity).supportFragmentManager
            val view = FragmentContainerView(it).apply {
                id = R.id.fragment_container_view_tag
            }
            val fragment1 = YouTubePlayerSupportFragmentXKt().apply {
                initialize(
                    BuildConfig.API_KEYY,
                    object : YouTubePlayer.OnInitializedListener {
                        override fun onInitializationFailure(
                            provider: YouTubePlayer.Provider,
                            result: YouTubeInitializationResult
                        ) {
                            Toast.makeText(
                                context,
                                "Error initializing video",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }

                        override fun onInitializationSuccess(
                            provider: YouTubePlayer.Provider,
                            player: YouTubePlayer,
                            wasRestored: Boolean
                        ) {
                            // TODO closing this screen when the player is in fullscreen
                            //  is making the app keep in landscape. Disabling for now.
                            player.setShowFullscreenButton(false)
                            if (!wasRestored) {
                                player.cueVideo(videoId)
                            }
                        }
                    },
                )
            }
            fm.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view_tag, fragment1)
            }
           view
        },
    )
}