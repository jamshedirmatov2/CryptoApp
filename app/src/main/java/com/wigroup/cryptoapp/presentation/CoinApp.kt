package com.wigroup.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import com.wigroup.cryptoapp.data.worker.CoinWorkerFactory
import com.wigroup.cryptoapp.di.DaggerApplicationComponent
import javax.inject.Inject

class CoinApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: CoinWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory).build()

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}