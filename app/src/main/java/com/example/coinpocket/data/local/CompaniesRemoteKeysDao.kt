package com.example.coinpocket.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coinpocket.domain.model.CompanyListRemoteKeys

@Dao
interface CompaniesRemoteKeysDao {

    @Query("SELECT * FROM company_remote_keys WHERE id = :id")
    suspend fun getCompanyRemoteKeys(id: Int?): CompanyListRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllCompanyRemoteKeys(movieRemoteKeys : List<CompanyListRemoteKeys>)

    @Query("DELETE FROM company_remote_keys")
    suspend fun deleteAllCompanyRemoteKeys()
}