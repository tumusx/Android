package com.github.tumusx.core_database.instanceDataBase

import android.content.Context
import androidx.room.Room
import com.github.tumusx.core_database.database.AppDatabase

object InstanceDatabase {
    fun instanceDataBase(context: Context, databaseName: String) : AppDatabase{
       return Room.databaseBuilder(context, AppDatabase::class.java, databaseName).build()
    }
}