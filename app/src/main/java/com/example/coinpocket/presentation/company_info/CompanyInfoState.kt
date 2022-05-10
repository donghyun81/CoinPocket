package com.example.coinpocket.presentation.company_info

import com.example.coinpocket.domain.model.IntradayInfo

data class CompanyInfoState (
    val stockInfos:List<IntradayInfo> = emptyList(),
    val company:CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error:String?= null
        )