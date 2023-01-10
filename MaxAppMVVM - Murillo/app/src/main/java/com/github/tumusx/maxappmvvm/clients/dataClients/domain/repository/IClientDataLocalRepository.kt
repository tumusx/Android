package com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository

import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientDTO

interface IClientDataLocalRepository {
    suspend fun getDataClientLocalDatabase(): ClientDTO?
    suspend fun insertDataClientLocalDatabase(clientDTO: ClientDTO)
}