package com.github.tumusx.maxappmvvm.clients.dataClients.repository

import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientDTO
import com.github.tumusx.maxappmvvm.clients.dataClients.domain.repository.IClientDataLocalRepository

class ClientFakeLocalRepository : IClientDataLocalRepository {
    override suspend fun getDataClientLocalDatabase(): ClientDTO {
        return ClientDTO(
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

    override suspend fun insertDataClientLocalDatabase(clientDTO: ClientDTO) {}
}