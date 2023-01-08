package com.github.tumusx.maxappmvvm.clients.dataClients.domain.model

import com.google.gson.annotations.SerializedName

data class ClientsDTO(
    @SerializedName("cliente")
    val clientDTO: ClientDTO
)


data class ClientDTO(
    @SerializedName("cnpj")
    val cnpj: String,

    @SerializedName("codigo")
    val codigo: String,

    @SerializedName("contatos")
    val contatos: List<Contato>,

    @SerializedName("endereco")
    val endereco: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("nomeFantasia")
    val nomeFantasia: String,

    @SerializedName("ramo_atividade")
    val ramoAtividade: String,

    @SerializedName("razao_social")
    val razaoSocial: String,

    @SerializedName("status")
    val status: String
)