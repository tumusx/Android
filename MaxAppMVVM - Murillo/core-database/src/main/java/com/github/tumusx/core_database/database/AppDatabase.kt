package com.github.tumusx.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.tumusx.core_database.dao.ClientDao
import com.github.tumusx.core_database.dao.HistoricDao
import com.github.tumusx.core_database.entitys.ClientEntity
import com.github.tumusx.core_database.entitys.Converters
import com.github.tumusx.core_database.entitys.HistoricEntity
import com.github.tumusx.core_database.entitys.PedidoEntity


@Database(
    entities = [ClientEntity::class, HistoricEntity::class],
    exportSchema = false,
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract  fun clientDAO(): ClientDao
    abstract fun historicDAO() : HistoricDao
}