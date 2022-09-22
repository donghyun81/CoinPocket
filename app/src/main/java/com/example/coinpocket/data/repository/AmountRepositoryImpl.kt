package com.example.coinpocket.data.repository

import com.example.coinpocket.data.local.AmountEntity
import com.example.coinpocket.data.local.AmountDao
import com.example.coinpocket.domain.model.CategoryImage
import com.example.coinpocket.domain.repository.AmountRepository
import kotlinx.coroutines.flow.Flow

class AmountRepositoryImpl(private val dao: AmountDao):AmountRepository {
    override suspend fun insertAmount(amountEntity: AmountEntity) {
        dao.insertAmount(amountEntity = amountEntity)
    }

    override suspend fun getAmount(id: Int): AmountEntity? {
       return dao.getAmount(id)
    }

    override fun getDays(): Flow<List<String>> {
        return dao.getDays()
    }

    override fun getDayAmout(day: String): Flow<List<Int>> {
        return dao.getDayAmount(day)
    }

    override suspend fun updateAmount(id:Int?,
                                      title:String,
                                      isDeposit:Boolean,
                                      day: String,
                                      categoryImage:CategoryImage ,
                                      content:String,
                                      amount:Long,
                                        ) {
        return dao.updateAmount(
            id,
            title,
            isDeposit,
            day,
            categoryImage,
            content,
            amount,
            )
    }


    override fun getDayAccounts(day: String): Flow<List<AmountEntity>> {
        return dao.getDayAmounts(day)
    }

    override fun getAccounts(): Flow<List<AmountEntity>> {
        return dao.getAmounts()
    }

    override suspend fun deleteCoin(amountEntity: AmountEntity) {
        return dao.deleteAmount(amountEntity=amountEntity)
    }

}