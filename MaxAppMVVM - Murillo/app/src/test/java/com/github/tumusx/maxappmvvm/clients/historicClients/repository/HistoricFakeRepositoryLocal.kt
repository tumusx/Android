package com.github.tumusx.maxappmvvm.clients.historicClients.repository

import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.HistoricDTO
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.Pedido
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository.IHistoricLocalRepository

class HistoricFakeRepositoryLocal : IHistoricLocalRepository {

    override suspend fun getHistoric(): List<Pedido> {
        return listOf(
            Pedido(
                "Murillo", "21", "CRITICA_0",
                "21-10-11", listOf("LEGENDA_2", "LEGENDA_1"), 12, "121421", "Ativo", "Cliente"
            )
        )
    }

    override suspend fun insertHistoric(historic: HistoricDTO) {

    }
}