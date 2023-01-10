package com.github.tumusx.core_database.entitys

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<ContactEntity>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun listToJsonPedido(value: List<PedidoEntity>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<ContactEntity> {
        val contactListArray =
            Gson().fromJson(value, Array<ContactEntity>::class.java) as Array<ContactEntity>
        return contactListArray.toList()
    }



    @TypeConverter
    fun jsonToListPedidoEntity(value: String): List<PedidoEntity> {
        val contactListArray =
            Gson().fromJson(value, Array<PedidoEntity>::class.java) as Array<PedidoEntity>
        return contactListArray.toList()
    }
}