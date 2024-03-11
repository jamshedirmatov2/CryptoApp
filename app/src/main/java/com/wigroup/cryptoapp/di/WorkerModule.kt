package com.wigroup.cryptoapp.di

import com.wigroup.cryptoapp.data.worker.ChildWorkerFactory
import com.wigroup.cryptoapp.data.worker.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(worker: RefreshDataWorker.Factory): ChildWorkerFactory
}