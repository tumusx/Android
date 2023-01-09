package com.github.tumusx.core_database.entitys

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historic")
data class HistoricEntity(
    @PrimaryKey
    val idHistoric: Long,
    val nomeClient: String,
    val codigoCliente: String,
    val critica: String?,
    val data: String,
    @Embedded
    val legendas: List<String>,
    val numeroPedRca: Int,
    val numeroPedErp: String,
    val status: String,
    val tipo: String
)