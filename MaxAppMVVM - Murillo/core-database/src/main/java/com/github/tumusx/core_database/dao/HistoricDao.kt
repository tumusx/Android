package com.github.tumusx.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.tumusx.core_database.entitys.HistoricEntity

@Dao
interface HistoricDao {
    @Query("SELECT * FROM historic_pedido")
    suspend fun getHistoric(): HistoricEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoric(vararg historicEntity: HistoricEntity)
}
