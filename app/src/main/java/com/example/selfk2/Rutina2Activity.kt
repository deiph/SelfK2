package com.example.selfk2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.example.selfk2.database.App
import com.example.selfk2.database.HistorialEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Rutina2Activity : AppCompatActivity() {

    //VARIABLE PARA EL HISTORIAL
    val rutina = 2
    @RequiresApi(Build.VERSION_CODES.O)
    val dateTime = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutina2)
        title = "Rutina de ejercicios"
        Toast.makeText(applicationContext,"Rutina sin crear", Toast.LENGTH_SHORT).show()

        findViewById<Button>(R.id.finBt).setOnClickListener {
            lifecycleScope.launch(){
                withContext(Dispatchers.IO){
                    App.getDb().HistorialDao().save(
                        HistorialEntity(rutina = "Rutina $rutina",
                        fecha = " ${dateTime.format(DateTimeFormatter.ofPattern("M/d/y H:m:ss"))}")
                    )
                }
            }
            val intent = Intent (this, ElegirActivity::class.java)
            startActivity(intent)

        }
    }
}