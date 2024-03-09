package com.wigroup.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.map
import com.wigroup.cryptoapp.data.database.AppDatabase
import com.wigroup.cryptoapp.data.mapper.CoinMapper
import com.wigroup.cryptoapp.data.network.ApiFactory
import com.wigroup.cryptoapp.domain.CoinRepository
import kotlinx.coroutines.delay

class CoinRepositoryImpl(
    application: Application
) : CoinRepository {

    private val coinInfoDao = AppDatabase.getInstance(application).coinPriceInfoDao()
    private val apiService = ApiFactory.apiService

    private val mapper = CoinMapper()

    override fun getCoinInfoList() = coinInfoDao.getPriceList().map { list ->
        list.map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun getCoinInfo(fromSymbol: String) =
        coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }

    override suspend fun loadData() {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val fSym = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSym)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (_: Exception) {
            }
            delay(10000)
        }
    }
}