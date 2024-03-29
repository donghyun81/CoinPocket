package com.example.coinpocket.presentation.company_listings


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpocket.data.remote.ApiService
import com.example.coinpocket.data.remote.CompaniesApi
import com.example.coinpocket.domain.model.SearchResponse
import com.example.coinpocket.domain.use_case.stock.StockUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

@HiltViewModel
class CompanyListingsViewModel @Inject constructor(
    private val stockUsecases: StockUsecases,
    ):ViewModel(){
    val getAllCompanies = stockUsecases.getCompaniesUseCase()


}