package com.example.coinpocket.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coinpocket.domain.model.CompanyListingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CompaniesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCompanies(companies: List<CompanyListingEntity>)

    @Query("SELECT * FROM companylistingentity")
    fun getAllCompany(): PagingSource<Int, CompanyListingEntity>

    @Query("SELECT * FROM companylistingentity WHERE id = :id")
    fun getCompany(id: Int): Flow<CompanyListingEntity>

    @Query("DELETE FROM companylistingentity")
    suspend fun deleteAllCompany()
}