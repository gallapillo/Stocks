package com.gallapillo.stocks.data.remote

import com.gallapillo.stocks.utils.ApiKey
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {


    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String
    ): ResponseBody

    companion object {
        const val API_KEY = ApiKey.API_KEY
        const val BASE_URL = "https://alphavantage.co"
    }
}