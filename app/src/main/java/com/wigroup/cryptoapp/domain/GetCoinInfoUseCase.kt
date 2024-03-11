package com.wigroup.cryptoapp.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetCoinInfoUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(fromSymbol: String): LiveData<CoinInfo> =
        repository.getCoinInfo(fromSymbol)
}