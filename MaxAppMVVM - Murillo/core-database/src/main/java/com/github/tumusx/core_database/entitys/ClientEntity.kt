package com.github.tumusx.core_database.entitys

import androidx.room.*

@Entity(tableName = "client")
data class ClientEntity(
    @PrimaryKey var clientID: Long? = null,
    @ColumnInfo(name = "cnpj")
    val cnpj: String,

    @ColumnInfo(name = "codigo")
    val code: String,

    @ColumnInfo(name = "contatos")
    val contact: List<ContactEntity>,

    @ColumnInfo(name = "endereco")
    val address: String,

    @ColumnInfo(name = "id_client_user")
    val id: Int,

    @ColumnInfo(name = "nome_fantasia")
    val fantasyName: String,

    @ColumnInfo(name = "ramo_atividade")
    val activityClient: String,

    @ColumnInfo(name = "razao_social")
    val companyName: String,

    @ColumnInfo(name = "status")
    val status: String
)