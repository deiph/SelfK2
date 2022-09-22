package com.example.selfk2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.selfk2.database.App
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Inicio de usuario"

        val email = intent.getStringExtra("email")
        saludoTextView.text = "Bienvenido $email"


        //LOS TRES BOTONES DE ESTA PANTALLA TIENEN SUS FUNCIONES QUE LLEVAN A OTRAS ACTIVIDADES

        inicioBt.setOnClickListener {
            val intent = Intent(this, ElegirActivity::class.java)
            startActivity(intent)
        }
        imcBt.setOnClickListener {
            val intent = Intent(this, IMCActivity::class.java)
            startActivity(intent)
        }

        histBt.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)
        }

        deleteHistBt.setOnClickListener {
            Toast.makeText(applicationContext, "Se ha borrado el historial", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch{
                withContext(Dispatchers.IO) {
                    App.getDb().HistorialDao().deleteAll()

                }
            }
        }
    }
}