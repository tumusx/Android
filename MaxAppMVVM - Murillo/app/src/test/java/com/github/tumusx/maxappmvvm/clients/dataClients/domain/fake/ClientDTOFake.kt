package com.github.tumusx.maxappmvvm.clients.dataClients.domain.fake

import com.github.tumusx.maxappmvvm.clients.dataClients.domain.model.Contato


data class ClientDTOFake(
    var cnpj: String,

    var codigo: String,

    var contatos: List<ContactsDTOFake>,

    var endereco: String,

    var id: Int,

    var nomeFantasia: String,

    var ramoAtividade: String,

    var razaoSocial: String,

    var status: String
)