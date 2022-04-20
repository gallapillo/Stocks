package com.gallapillo.stocks.data.remote

import com.gallapillo.stocks.data.remote.dto.CompanyInfoDto
import com.gallapillo.stocks.domain.model.CompanyInfo
import com.gallapillo.stocks.utils.ApiKey
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {


    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    @GET("query?function=TIME_SERIRES_INTRADAY&interval=60min&datatype=csv")
    suspend fun getIntradayInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apikey: String = API_KEY
    ): ResponseBody

    @GET("query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY
    ): CompanyInfoDto

    companion object {
        const val API_KEY = ApiKey.API_KEY
        const val BASE_URL = "https://alphavantage.co"
    }
}