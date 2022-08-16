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
        imageUrl: Int,
        content:String,
        amount:Int)

    suspend fun getAmount(id: Int): AmountEntity?

    fun getDays():Flow<List<String>>

    fun getDayAmout(day:String):Flow<List<Int>>

    fun getDayAccounts(day:String): Flow<List<AmountEntity>>

    fun getAccounts():Flow<List<AmountEntity>>

    suspend fun deleteCoin(amountEntity: AmountEntity)

}