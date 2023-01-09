package com.github.tumusx.maxappmvvm.clients.historicClient.di

import com.github.tumusx.core_network.RetrofitInstance
import com.github.tumusx.maxappmvvm.clients.dataClients.di.IoDispatcher
import com.github.tumusx.maxappmvvm.clients.historicClient.data.api.HistoricServiceAPI
import com.github.tumusx.maxappmvvm.clients.historicClient.data.repository.HistoricRepositoryImpl
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository.IHistoricRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object AppModuleHistoric {
    @Provides
    @Singleton
    fun provideAPIHistoric(): HistoricServiceAPI {
        return RetrofitInstance.retrofitInstance.create(HistoricServiceAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideHistoricRepository(api: HistoricServiceAPI): IHistoricRepository {
        return HistoricRepositoryImpl(api)
    }
}