package com.example.coinpocket.presentation.amount_detail

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.CategoryImage
import com.example.coinpocket.domain.model.incomeCategoryImages

data class AmountDetailState (
    val day:String="",
    val categoryImage: CategoryImage = incomeCategoryImages[0],
    val isDeposit:Boolean = true,
    val amount:Long=0,
    val title:String = "",
    val content:String="",
    val amountEntity:AmountEntity? =null
)