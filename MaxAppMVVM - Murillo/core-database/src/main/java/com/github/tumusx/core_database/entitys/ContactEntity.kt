package com.github.tumusx.core_database.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "contact"
)
data class ContactEntity(
    @PrimaryKey var contactId: Long? = null,

    @ColumnInfo(name = "celular")
    val celular: String,

    @ColumnInfo(name = "conjuge")
    val conjuge: String,

    @ColumnInfo(name = "data_nascimento_conjuge")
    val bithClientConjuge: String,

    @ColumnInfo(name = "data_nascimento")
    val bithClient: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "name")
    val nome: String,

    @ColumnInfo(name = "telefone")
    val telefone: String,

    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "tipo")
    val tipo: String
)