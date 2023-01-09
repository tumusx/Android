package com.github.tumusx.core_database.entitys

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "contact",
    foreignKeys = [ForeignKey(
        entity = ClientEntity::class,
        parentColumns = arrayOf("clientID"),
        childColumns = arrayOf("clientContactID"),
        onDelete = CASCADE
    )]
)
data class ContactEntity(
    @PrimaryKey val contactId: Long,
    val clientContactID: Long,
    val celular: String,
    val conjuge: String,
    val dataNascimentoConjuge: String,
    val dataNascimento: String,
    val e_mail: String,
    val nome: String,
    val telefone: String,
    val time: String,
    val tipo: String
)