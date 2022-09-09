package com.example.coinpocket.presentation.coin_add_salary


import com.example.coinpocket.domain.model.CategoryImage
import com.example.coinpocket.domain.model.incomeCategoryImages


data class CoinAddSalaryState (
    val day:String="",
    val categoryImage: CategoryImage = incomeCategoryImages[0],
    val isDeposit:Boolean = true,
    val amount:Int=0,
    val title:String = "",
    val content:String="",
        )