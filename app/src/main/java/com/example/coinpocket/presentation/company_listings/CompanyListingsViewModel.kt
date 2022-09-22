package com.example.coinpocket.presentation.company_listings


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpocket.data.remote.CompaniesApi
import com.example.coinpocket.domain.use_case.stock.StockUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyListingsViewModel @Inject constructor(
    private val stockUsecases: StockUsecases,
    ):ViewModel(){
    val getAllCompanies = stockUsecases.getCompaniesUseCase()

}