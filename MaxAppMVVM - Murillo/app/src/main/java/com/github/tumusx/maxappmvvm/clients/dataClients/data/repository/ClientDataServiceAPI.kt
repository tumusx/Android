package com.github.tumusx.maxappmvvm.clients.dataClients.data.repository

import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.ClientsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ClientDataServiceAPI {

    @Headers("Content-Type:application/json")
    @GET("cliente")
    suspend fun consultClient() : Response<ClientsDTO>
}