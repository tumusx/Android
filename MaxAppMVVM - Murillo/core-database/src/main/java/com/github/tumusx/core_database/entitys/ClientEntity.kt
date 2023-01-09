package com.github.tumusx.core_database.entitys

import androidx.room.*

/*data class ClientWithContacts(
    @Embedded val client: ClientEntity,
    @Relation(
        parentColumn = "",
        entityColumn = ""
    )
    val contatos: List<ContactEntity>
)*/


@Entity(tableName = "client")
data class ClientEntity(
    @PrimaryKey var clientID: Long? = null,

    val cnpj: String,

    val codigo: String,

    @Embedded
    val contatos: List<ContactEntity>,

    val endereco: String,

    val id: Int,

    val nomeFantasia: String,

    val ramoAtividade: String,

    val razaoSocial: String,

    val status: String
)