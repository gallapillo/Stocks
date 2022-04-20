package com.gallapillo.stocks.data.mapper

import com.gallapillo.stocks.data.local.CompanyListingEntity
import com.gallapillo.stocks.data.remote.dto.CompanyInfoDto
import com.gallapillo.stocks.domain.model.CompanyInfo
import com.gallapillo.stocks.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}