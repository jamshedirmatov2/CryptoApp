package com.wigroup.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.wigroup.cryptoapp.data.repository.CoinRepositoryImpl
import com.wigroup.cryptoapp.domain.GetCoinInfoListUseCase
import com.wigroup.cryptoapp.domain.GetCoinInfoUseCase
import com.wigroup.cryptoapp.domain.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    init {
        loadDataUseCase()
    }

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)
}