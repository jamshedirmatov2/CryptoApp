package com.wigroup.cryptoapp.di

import android.app.Application
import com.wigroup.cryptoapp.data.database.AppDatabase
import com.wigroup.cryptoapp.data.database.CoinInfoDao
import com.wigroup.cryptoapp.data.network.ApiFactory
import com.wigroup.cryptoapp.data.network.ApiService
import com.wigroup.cryptoapp.data.repository.CoinRepositoryImpl
import com.wigroup.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(application: Application): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}