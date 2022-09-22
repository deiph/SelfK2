package com.example.selfk2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = arrayOf(HistorialEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun HistorialDao(): HistorialDao

    companion object{
        private var db:AppDatabase?=null
        fun getDB(context: Context): AppDatabase{
            if (db==null){
                db = Room.databaseBuilder(
                    context, AppDatabase::class.java, "HistorialDB"
                ).build()
            }
            return db!!
        }

    }

}