package com.example.selfk2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_elegir.*

class ElegirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elegir)
        title = "¿Qué actividad quieres realizar?"

        r1Bt.setOnClickListener{
            val intent = Intent (this, Rutina1Activity::class.java)
            startActivity(intent)
        }

        r2Bt.setOnClickListener{
            val intent = Intent (this, Rutina2Activity::class.java)
            startActivity(intent)
        }

        r3Bt.setOnClickListener{
            val intent = Intent (this, Rutina3Activity::class.java)
            startActivity(intent)
        }


        //FUNCIÓN DESHABILITADA
        crearBt.setOnClickListener{
            Toast.makeText(applicationContext,"Función deshabilitada",Toast.LENGTH_SHORT).show()
        }

        //FUNCIÓN DESHABILITADA
        editBt.setOnClickListener{
            Toast.makeText(applicationContext,"Función deshabilitada",Toast.LENGTH_SHORT).show()
        }
    }
}