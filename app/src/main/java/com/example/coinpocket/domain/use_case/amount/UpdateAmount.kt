package com.example.coinpocket.domain.use_case.amount

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.CategoryImage
import com.example.coinpocket.domain.repository.AmountRepository

class UpdateAmount (
    private val repository: AmountRepository
){
    suspend operator fun invoke(id:Int?,
                                title:String,
                                isDeposit:Boolean,
                                day: String,
                                categoryImage:CategoryImage,
                                content:String,
                                amount:Long,
                                ){
        repository.updateAmount(
            id,
            title,
            isDeposit,
            day,
            categoryImage,
            content,
            amount,
            )
    }
}