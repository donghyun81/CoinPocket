package com.example.coinpocket.data.repository

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.data.local.AmountDao
import com.example.coinpocket.domain.model.IconSample
import com.example.coinpocket.domain.repository.AmountRepository
import kotlinx.coroutines.flow.Flow

class AmountRepositoryImpl(private val dao: AmountDao):AmountRepository {
    override suspend fun insertAmount(amountEntity: AmountEntity) {
        dao.insertAmount(amountEntity = amountEntity)
    }

    override suspend fun getAmount(id: Int): AmountEntity? {
       return dao.getAmount(id)
    }

    override suspend fun updateAmount(id:Int?,
                                      title:String,
                                      isDeposit:Boolean,
                                      day: String,
                                      icon: IconSample?,
                                      content:String,
                                      amount:Int) {
        return dao.updateAmount(
            id,
            title,
            isDeposit,
            day,
            icon,
            content,
            amount)
    }


    override suspend fun getDayAccounts(day: String): Flow<List<AmountEntity>> {
        return dao.getDayAmounts(day)
    }

    override suspend fun deleteCoin(amountEntity: AmountEntity) {
        return dao.deleteAmount(amountEntity=amountEntity)
    }

}