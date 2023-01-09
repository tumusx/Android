package com.github.tumusx.maxappmvvm.clients.historicClient.data.api

import com.github.tumusx.maxappmvvm.clients.historicClient.domain.model.HistoricDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface HistoricServiceAPI {

    @GET("pedido")
    @Headers("Content-Type:application/json")
    suspend fun searchHistoric() : Response<HistoricDTO>
}
