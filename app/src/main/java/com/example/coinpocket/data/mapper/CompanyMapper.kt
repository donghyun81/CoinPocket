package com.example.coinpocket.data.mapper

import com.example.coinpocket.data.local.CompanyListingEntity
import com.example.coinpocket.data.remote.dto.CompanyInfoDto
import com.example.coinpocket.domain.model.CompanyListing
import com.example.coinpocket.presentation.company_info.CompanyInfo

fun CompanyListingEntity.toCompanyListing():CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity():CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?:"",
        description = description?:"",
        name = name?:"",
        country = country?:"",
        industry = industry?:""
    )

}