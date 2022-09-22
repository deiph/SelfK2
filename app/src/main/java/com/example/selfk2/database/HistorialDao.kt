package com.example.selfk2.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface HistorialDao {

    @Query ("SELECT * FROM Historial")
    fun findAll(): List<HistorialEntity>

    @Query("DELETE FROM Historial")
    fun deleteAll()

    @Insert
    fun save(Historial: HistorialEntity)

    @Delete
    fun delete (Historial: HistorialEntity)

}