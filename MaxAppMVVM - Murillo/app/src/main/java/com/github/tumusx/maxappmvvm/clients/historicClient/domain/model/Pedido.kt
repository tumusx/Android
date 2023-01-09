package com.github.tumusx.maxappmvvm.clients.historicClient.domain.model

import com.google.gson.annotations.SerializedName

data class Pedido(
    @SerializedName("NOMECLIENTE")
    val nomeClient: String,
    val codigoCliente: String,
    val critica: String?,
    val data: String,
    val legendas: List<String>?,
    @SerializedName("numero_ped_Rca")
    val numeroPedRca: Int,
    @SerializedName("numero_ped_erp")
    val numeroPedErp: String,
    val status: String,
    val tipo: String
)