package com.github.tumusx.maxappmvvm.clients.historicClient.data.repository

import com.github.tumusx.core_network.ApiResult
import com.github.tumusx.maxappmvvm.clients.historicClient.data.api.HistoricServiceAPI
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.HistoricDTO
import com.github.tumusx.maxappmvvm.clients.historicClient.domain.repository.IHistoricRepository
import javax.inject.Inject

class HistoricRepositoryImpl @Inject constructor(private val historicService: HistoricServiceAPI) :
    IHistoricRepository {
    override suspend fun searchHistoricClient(): ApiResult<HistoricDTO?> {
        val response = historicService.searchHistoric()
        if (response.body()?.request?.isEmpty() == true || response.body()?.request == null) return ApiResult.Error(
            "Sem dados. Consulte no ERP!"
        )
        return if (response.isSuccessful) {
            ApiResult.Success(response.body())
        } else {
            ApiResult.Error(response.errorBody().toString())
        }
    }
}