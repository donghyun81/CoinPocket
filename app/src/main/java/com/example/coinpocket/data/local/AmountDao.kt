package com.example.coinpocket.data.local

import androidx.room.*
import com.example.coinpocket.domain.model.CategoryImage
import kotlinx.coroutines.flow.Flow

@Dao
interface AmountDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertAmount(amountEntity: AmountEntity)

    @Query("update AmountEntity set title =:title," +
            "isDeposit=:isDeposit," +
            "day=:day," +
            "categoryImage=:categoryImage," +
            "content=:content," +
            "amount=:amount where id=:id")
    suspend fun updateAmount(
        id:Int?,
        title:String,
        isDeposit:Boolean,
        day: String,
        categoryImage:CategoryImage,
        content:String,
        amount:Long,
    )

    @Query("select * from AmountEntity where id= :id")
    suspend fun getAmount(id:Int):AmountEntity?

    @Query("select * from AmountEntity where day= :day")
    fun getDayAmounts(day:String): Flow<List<AmountEntity>>

    @Delete
    suspend fun deleteAmount(amountEntity: AmountEntity)

    @Query("select * from AmountEntity")
    fun getAmounts():Flow<List<AmountEntity>>

    @Query("select amount from AmountEntity where day= :day")
    fun getDayAmount(day: String):Flow<List<Int>>

    @Query("select day from AmountEntity")
    fun getDays():Flow<List<String>>

}