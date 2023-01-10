package com.github.tumusx.maxappmvvm.clients.dataClients.di

import android.app.Application
import androidx.room.Room
import com.github.tumusx.core_database.database.AppDatabase
import com.github.tumusx.core_network.RetrofitInstance
import com.github.tumusx.maxappmvvm.clients.dataClients.data.api.ClientDataServiceAPI
import com.github.tumusx.maxappmvvm.clients.dataClients.data.repository.ClientDataRepositoryImpl
import com.github.tumusx.maxappmvvm.clients.dataClients.data.repository.ClientLocalRepositoryImpl
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataLocalRepository
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository
import com.github.tumusx.maxappmvvm.clients.historicClient.data.api.HistoricServiceAPI
import com.github.tumusx.maxappmvvm.clients.historicClient.data.repository.HistoricLocalRepositoryImpl
import com.github.tumusx.maxappmvvm.clients.historicClient.data.repository.HistoricRepositoryImpl
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository.IHistoricLocalRepository
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository.IHistoricRepository
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

    @Provides
    @Singleton
    fun provideAPIHistoric(): HistoricServiceAPI {
        return RetrofitInstance.retrofitInstance.create(HistoricServiceAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideLasHistoricDa(appDatabase: AppDatabase): IHistoricLocalRepository {
        return HistoricLocalRepositoryImpl(appDatabase)
    }

    @Provides
    @Singleton
    fun provideHistoricRepository(api: HistoricServiceAPI): IHistoricRepository {
        return HistoricRepositoryImpl(api)
    }

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun roomInstanceDB(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "appdatabaseutil.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideSampleClient(appDatabase: AppDatabase): IClientDataLocalRepository {
        return ClientLocalRepositoryImpl(appDatabase)
    }

    @Provides
    @Singleton
    fun provideRepository(api: ClientDataServiceAPI): IClientDataRepository {
        return ClientDataRepositoryImpl(api)
    }
}