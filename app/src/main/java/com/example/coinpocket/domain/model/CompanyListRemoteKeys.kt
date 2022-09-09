package com.example.coinpocket.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company_remote_keys")
data class CompanyListRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?,
)