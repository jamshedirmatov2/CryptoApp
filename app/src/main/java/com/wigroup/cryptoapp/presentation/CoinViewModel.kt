package com.wigroup.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import com.wigroup.cryptoapp.domain.GetCoinInfoListUseCase
import com.wigroup.cryptoapp.domain.GetCoinInfoUseCase
import com.wigroup.cryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    loadDataUseCase: LoadDataUseCase,
) : ViewModel() {

    init {
        loadDataUseCase()
    }

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)
}