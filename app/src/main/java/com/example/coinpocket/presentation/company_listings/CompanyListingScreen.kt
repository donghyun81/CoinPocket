package com.example.coinpocket.presentation.company_listings


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
    route = Routes.Companies,
    start = true,
    navGraph = Routes.Companies_NAV_GRAPH,
)
fun CompanyListingScreen(
    viewModel: CompanyListingsViewModel = hiltViewModel()
) {
    val allCompanies = viewModel.getAllCompanies.collectAsLazyPagingItems()

    Scaffold(
        content = {
            CompanyListContent(allCompanies = allCompanies)

        }
    )
}
