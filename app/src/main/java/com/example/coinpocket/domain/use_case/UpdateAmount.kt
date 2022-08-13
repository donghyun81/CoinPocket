package com.example.coinpocket.domain.use_case

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.repository.AmountRepository

class UpdateAmount (
    private val repository: AmountRepository
){
    suspend operator fun invoke(id:Int?,
                                title:String,
                                isDeposit:Boolean,
                                day: String,
                                icon: ImageVector,
                                content:String,
                                amount:Int){
        repository.updateAmount(
            id,
            title,
            isDeposit,
            day,
            icon,
            content,
            amount)
    }
}