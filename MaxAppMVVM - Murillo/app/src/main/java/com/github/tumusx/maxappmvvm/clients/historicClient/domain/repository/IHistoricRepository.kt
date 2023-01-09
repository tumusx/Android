package com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository

import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.HistoricDTO

interface IHistoricRepository {
    suspend fun searchHistoricClient () : ApiResult<HistoricDTO?>
}