    package com.github.tumusx.maxappmvvm.clients.dataClients.di

    import com.github.tumusx.core_network.RetrofitInstance
    import com.github.tumusx.maxappmvvm.clients.dataClients.data.api.ClientDataRepositoryImpl
    import com.github.tumusx.maxappmvvm.clients.dataClients.data.repository.ClientDataServiceAPI
    import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository
    import dagger.Module
    import dagger.Provides
    import dagger.hilt.InstallIn
    import dagger.hilt.components.SingletonComponent
    import kotlinx.coroutines.CoroutineScope
    import kotlinx.coroutines.SupervisorJob
    import javax.inject.Qualifier
    import javax.inject.Singleton

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
        fun provideRepository(api: ClientDataServiceAPI): IClientDataRepository {
            return ClientDataRepositoryImpl(api)
        }
    }