package com.gallapillo.stocks.domain.repository

import com.gallapillo.stocks.domain.model.CompanyListing
import com.gallapillo.stocks.utils.Resource
import kotlinx.coroutines.flow.Flow


interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

}