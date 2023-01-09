package com.github.tumusx.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.github.tumusx.core_database.entitys.ClientEntity
import com.github.tumusx.core_database.entitys.HistoricEntity

interface ClientDAO {
/*    @Transaction
    @Query("SELECT * FROM client")
     fun getContacts(): List<ClientWithContacts>*//*

    @Query("SELECT * FROM client")
     fun getClient(): ClientEntity

    @Insert
     fun insertClient(vararg clientEntity: ClientEntity)

    @Insert
     fun insertHistoric(vararg historic: HistoricEntity)

    @Query("SELECT * FROM historic")
     fun getHistoric(): List<HistoricEntity>*/
}
