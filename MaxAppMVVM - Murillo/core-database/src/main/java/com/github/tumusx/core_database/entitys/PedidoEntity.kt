package com.github.tumusx.core_database.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pedido")
data class PedidoEntity(
    @PrimaryKey
    var idPedido: Long? = null,
    @ColumnInfo(name = "nome_client")
    val nameClient: String,

    @ColumnInfo(name = "codigo_cliente")
    val codeClient: String,

    @ColumnInfo(name = "critica")
    val review: String?,

    @ColumnInfo(name = "data")
    val data: String,

    @ColumnInfo(name = "numero_ped_rca")
    val numberRequestRCA: Int,

    @ColumnInfo(name = "numero_ped_erp")
    val numberRequestERP: String,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "tipo")
    val type: String
)