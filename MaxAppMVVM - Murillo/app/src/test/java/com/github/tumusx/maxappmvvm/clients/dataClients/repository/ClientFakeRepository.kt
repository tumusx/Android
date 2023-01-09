package com.github.tumusx.maxappmvvm.clients.dataClients.repository

import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientDTO
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataRepository


class ClientFakeRepository(private val isSuccess: Boolean = true) : IClientDataRepository {

    companion object {
        val clientDTO = ClientDTO(
            "11111",
            "1",
            emptyList(),
            "RS42",
            2,
            "maximatech",
            "maximatech ponto com",
            "Informatica",
            "Ativo"
        )
    }

    override suspend fun getDataClient(): ApiResult<ClientDTO?> {
        return if (isSuccess) {
            ApiResult.Success(
                clientDTO
            )
        } else {
            ApiResult.Error("ERRO")
        }
    }
}