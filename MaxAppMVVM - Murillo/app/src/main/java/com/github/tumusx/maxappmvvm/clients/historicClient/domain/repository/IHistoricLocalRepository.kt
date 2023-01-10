package com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository

import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.HistoricDTO
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.Pedido

interface IHistoricLocalRepository {
    suspend fun getHistoric() : List<Pedido>?
    suspend fun insertHistoric(historic: HistoricDTO)
}