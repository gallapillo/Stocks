package com.gallapillo.stocks.data.repository

import com.gallapillo.stocks.data.local.StockDatabase
import com.gallapillo.stocks.data.mapper.toCompanyListing
import com.gallapillo.stocks.data.remote.StockApi
import com.gallapillo.stocks.domain.model.CompanyListing
import com.gallapillo.stocks.domain.repository.StockRepository
import com.gallapillo.stocks.utils.Resource
import com.opencsv.CSVReader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
  val api: StockApi,
  val db: StockDatabase
): StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try {
                val response = api.getListings()
                val csvReader = CSVReader(InputStreamReader(response.byteStream()))

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load a data"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load a data"))
            }
        }
    }


}