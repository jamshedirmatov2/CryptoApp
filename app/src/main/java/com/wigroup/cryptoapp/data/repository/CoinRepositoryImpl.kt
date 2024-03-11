package com.wigroup.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.wigroup.cryptoapp.data.database.CoinInfoDao
import com.wigroup.cryptoapp.data.mapper.CoinMapper
import com.wigroup.cryptoapp.data.worker.RefreshDataWorker
import com.wigroup.cryptoapp.domain.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val mapper: CoinMapper,
    private val coinInfoDao: CoinInfoDao,
    private val application: Application
) : CoinRepository {

    override fun getCoinInfoList() = coinInfoDao.getPriceList().map { list ->
        list.map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun getCoinInfo(fromSymbol: String) =
        coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }

    override fun loadData() {
        WorkManager.getInstance(application)
            .enqueueUniqueWork(
                RefreshDataWorker.NAME,
                ExistingWorkPolicy.REPLACE,
                RefreshDataWorker.makeRequest()
            )
    }
}