package com.example.coinpocket.domain.repository

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.domain.model.IconSample
import kotlinx.coroutines.flow.Flow

interface AmountRepository {

    suspend fun insertAmount(amountEntity:AmountEntity)

    suspend fun updateAmount(
        id:Int?,
        title:String,
        isDeposit:Boolean,
        day: String,
        icon: ImageVector,
        content:String,
        amount:Int)

    suspend fun getAmount(id: Int): AmountEntity?

    suspend fun getDayAccounts(day:String): Flow<List<AmountEntity>>

    suspend fun deleteCoin(amountEntity: AmountEntity)

}