package com.gallapillo.stocks.domain.repository

import com.gallapillo.stocks.domain.model.CompanyInfo
import com.gallapillo.stocks.domain.model.CompanyListing
import com.gallapillo.stocks.domain.model.IntradayInfo
import com.gallapillo.stocks.utils.Resource
import kotlinx.coroutines.flow.Flow


interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradyInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}