package com.github.tumusx.maxappmvvm.clients.dataClients.di

import com.github.tumusx.core_network.RetrofitInstance
import com.github.tumusx.maxappmvvm.clients.dataClients.data.api.ClientDataServiceAPI
import com.github.tumusx.maxappmvvm.clients.dataClients.data.repository.ClientDataRepositoryImpl
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ClientDataServiceAPI {
        return RetrofitInstance.retrofitInstance.create(ClientDataServiceAPI::class.java)
    }

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideRepository(api: ClientDataServiceAPI): IClientDataRepository {
        return ClientDataRepositoryImpl(api)
    }
}