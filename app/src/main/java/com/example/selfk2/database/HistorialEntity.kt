package com.example.selfk2.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Historial")

data class HistorialEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val rutina: String,
    val fecha: String
){
    override fun toString(): String{
        return "$rutina, fecha: $fecha \n"
    }
}
