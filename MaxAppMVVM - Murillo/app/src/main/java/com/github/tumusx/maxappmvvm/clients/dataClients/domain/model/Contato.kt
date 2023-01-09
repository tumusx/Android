package com.github.tumusx.maxappmvvm.clients.dataClients.domain.model

import com.google.gson.annotations.SerializedName

data class Contato(
    val celular: String,
    val conjuge: String,
    val dataNascimentoConjuge: String?,
    @SerializedName("data_nascimento")
    val dataNascimento: String,
    val e_mail: String,
    val nome: String,
    val telefone: String,
    val time: String,
    val tipo: String
)