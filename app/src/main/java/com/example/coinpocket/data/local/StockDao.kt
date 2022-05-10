package com.example.coinpocket.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockDao {

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertCompanyListings(
        companyListingEntities:List<CompanyListingEntity>
    )

    @Query("Delete From companylistingentity")
    suspend fun clearCompanyListings()

    @Query("""
        Select *
        From companylistingentity 
        where LOWER(name) LIKE '%' || LOWER(:query) || '%' OR UPPER(:query)== symbol

            
    """)
    suspend fun searchCompanyListings(query: String): List<CompanyListingEntity>
}