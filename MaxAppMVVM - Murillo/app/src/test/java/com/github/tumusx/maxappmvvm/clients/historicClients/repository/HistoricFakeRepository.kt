package com.github.tumusx.maxappmvvm.clients.historicClients.repository

import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.HistoricDTO
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.Pedido
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository.IHistoricRepository

class HistoricFakeRepository(private val success: Boolean = true) : IHistoricRepository {

    companion object {
        val listRequest = listOf(
            Pedido(
                "Murillo", "21", "CRITICA_0",
                "21-10-11", listOf("LEGENDA_2", "LEGENDA_1"), 12, "121421", "Ativo", "Cliente"
            )
        )
    }

    override suspend fun searchHistoricClient(): ApiResult<HistoricDTO?> {
        return if (success) {
            ApiResult.Success(HistoricDTO(listRequest))
        } else {
            ApiResult.Error("ERROR")
        }
    }
}