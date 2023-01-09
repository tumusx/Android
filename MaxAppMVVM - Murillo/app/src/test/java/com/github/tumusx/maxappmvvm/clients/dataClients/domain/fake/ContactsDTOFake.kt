package com.github.tumusx.maxappmvvm.clients.dataClients.domain.fake

import com.google.gson.annotations.SerializedName

data class ContactsDTOFake(
    var celular: String,
    var conjuge: String,
    var dataNascimentoConjuge: String,
    var dataNascimento: String,
    var e_mail: String,
    var nome: String,
    var telefone: String,
    var time: String,
    var tipo: String
)