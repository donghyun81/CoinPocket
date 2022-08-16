package com.example.coinpocket.data.local

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.*
import com.example.coinpocket.domain.model.IconSample
import kotlinx.coroutines.flow.Flow

@Dao
interface AmountDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertAmount(amountEntity: AmountEntity)

    @Query("update AmountEntity set title =:title," +
            "isDeposit=:isDeposit," +
            "day=:day," +
            "imageUrl=:imageUrl," +
            "content=:content," +
            "amount=:amount where id=:id")
    suspend fun updateAmount(
        id:Int?,
        title:String,
        isDeposit:Boolean,
        day: String,
        imageUrl: Int,
        content:String,
        amount:Int
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