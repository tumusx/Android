package com.github.tumusx.maxappmvvm.clients.historicClient.domain.model

import com.google.gson.annotations.SerializedName

data class HistoricDTO(
    @SerializedName("pedidos")
    val request: List<Pedido>
)