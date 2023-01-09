package com.github.tumusx.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.tumusx.core_database.dao.ClientDAO
import com.github.tumusx.core_database.entitys.ClientEntity
import com.github.tumusx.core_database.entitys.ContactEntity
import com.github.tumusx.core_database.entitys.HistoricEntity

@Database(
    entities = [ContactEntity::class, ClientEntity::class, HistoricEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDAO(): ClientDAO
}

