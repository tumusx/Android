package com.github.tumusx.core_database.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historic_pedido")
data class HistoricEntity(
    @PrimaryKey
    var idHistoric: Long? = null,
    val pedidoEntity: List<PedidoEntity>
)