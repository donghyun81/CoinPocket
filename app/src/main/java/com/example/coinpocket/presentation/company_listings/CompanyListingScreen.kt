package com.example.coinpocket.presentation.company_listings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.coinpocket.data.remote.CompaniesApi
import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.util.Routes
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@Composable
@Destination(
    route = Routes.MAIN_Companies,
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