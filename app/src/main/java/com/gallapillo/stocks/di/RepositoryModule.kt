package com.gallapillo.stocks.di

import com.gallapillo.stocks.data.csv.CompanyListingParser
import com.gallapillo.stocks.data.csv.CsvParser
import com.gallapillo.stocks.data.repository.StockRepositoryImpl
import com.gallapillo.stocks.domain.model.CompanyListing
import com.gallapillo.stocks.domain.repository.StockRepository
import com.opencsv.CSVParser
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingParser: CompanyListingParser
    ): CsvParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}