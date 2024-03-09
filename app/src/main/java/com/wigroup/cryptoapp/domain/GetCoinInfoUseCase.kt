package com.wigroup.cryptoapp.domain

import androidx.lifecycle.LiveData

class GetCoinInfoUseCase(private val repository: CoinRepository) {
    operator fun invoke(fromSymbol: String): LiveData<CoinInfo> =
        repository.getCoinInfo(fromSymbol)
}