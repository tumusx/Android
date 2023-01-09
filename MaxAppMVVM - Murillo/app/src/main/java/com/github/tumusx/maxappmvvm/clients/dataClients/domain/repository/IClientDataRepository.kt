package com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository

import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientDTO

interface IClientDataRepository {
    suspend fun getDataClient(): ApiResult<ClientDTO?>
}