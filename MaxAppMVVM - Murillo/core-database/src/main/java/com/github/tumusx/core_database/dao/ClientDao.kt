package com.github.tumusx.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.tumusx.core_database.entitys.ClientEntity

@Dao
interface ClientDao {
    @Query("SELECT * FROM client")
    suspend fun pegarClients(): ClientEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClient(vararg clientEntity: ClientEntity)
}

