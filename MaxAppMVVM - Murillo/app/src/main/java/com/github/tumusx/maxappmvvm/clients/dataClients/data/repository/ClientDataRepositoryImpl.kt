package com.github.tumusx.maxappmvvm.clients.dataClients.data.repository

import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.dataClients.data.api.ClientDataServiceAPI
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientDTO
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository
import javax.inject.Inject

class ClientDataRepositoryImpl @Inject constructor(
    private val serviceAPI: ClientDataServiceAPI) :
    IClientDataRepository {

    override suspend fun getDataClient(): ApiResult<ClientDTO?> {
        val response = serviceAPI.consultClient()
        if (response.body()?.clientDTO?.contatos?.isEmpty() == true || response.body() == null) return ApiResult.Error(
            "Sem conteúdo a ser exibido. Verificar no ERP"
        )
        return if (response.isSuccessful) {
            ApiResult.Success(response.body()?.clientDTO)
        } else {
            ApiResult.Error(response.errorBody().toString())
        }
    }
}