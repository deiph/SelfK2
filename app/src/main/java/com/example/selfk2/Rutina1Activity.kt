package com.example.selfk2


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.example.selfk2.database.App
import com.example.selfk2.database.HistorialEntity
import kotlinx.android.synthetic.main.activity_rutina1.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class Rutina1Activity : AppCompatActivity() {

    //VARIABLE DE INICIO = 30 SEGUNDOS
    val rutina = 1
    val start = 30000
    var timer = start
    lateinit var countDownTimer: CountDownTimer

    @RequiresApi(Build.VERSION_CODES.O)
    val dateTime = LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutina1)
        title = "Rutina de ejercicios"

        // AÑADIR AL HISTORIAL
        findViewById<Button>(R.id.finBt).setOnClickListener {
            lifecycleScope.launch() {
                withContext(Dispatchers.IO) {
                    App.getDb().HistorialDao().save(
                        HistorialEntity(
                            rutina = "Rutina $rutina",
                            fecha = " ${dateTime.format(DateTimeFormatter.ofPattern("M/d/y H:m:ss"))}"
                        )
                    )
                }
            }
            val intent = Intent(this, ElegirActivity::class.java)
            startActivity(intent)
        }

        // BOTONES DE PLAY/PAUSE CONTADOR
        var buttonClicked = false;
        findViewById<Button>(R.id.playBt1).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt2).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt3).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt4).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt5).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt6).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt7).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt8).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt9).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt10).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt11).setOnClickListener {
            startTimer()
        }
        findViewById<Button>(R.id.playBt12).setOnClickListener {
            startTimer()
        }
    }

    //    btn start
    private fun startTimer() {

        if (playBt1.isPressed) {
            playBt1.visibility = View.VISIBLE
            stopBt1.visibility = View.GONE
        } else if (playBt2.isPressed) {
            playBt2.visibility = View.VISIBLE
            stopBt2.visibility = View.GONE
        } else if (playBt3.isPressed) {
            playBt3.visibility = View.VISIBLE
            stopBt3.visibility = View.GONE
        } else if (playBt4.isPressed) {
            playBt4.visibility = View.VISIBLE
            stopBt4.visibility = View.GONE
        } else if (playBt5.isPressed) {
            playBt5.visibility = View.VISIBLE
            stopBt5.visibility = View.GONE
        } else if (playBt6.isPressed) {
            playBt6.visibility = View.VISIBLE
            stopBt6.visibility = View.GONE
        } else if (playBt7.isPressed) {
            playBt7.visibility = View.VISIBLE
            stopBt7.visibility = View.GONE
        } else if (playBt8.isPressed) {
            playBt8.visibility = View.VISIBLE
            stopBt8.visibility = View.GONE
        } else if (playBt9.isPressed) {
            playBt9.visibility = View.VISIBLE
            stopBt9.visibility = View.GONE
        } else if (playBt10.isPressed) {
            playBt10.visibility = View.VISIBLE
            stopBt10.visibility = View.GONE
        } else if (playBt11.isPressed) {
            playBt11.visibility = View.VISIBLE
            stopBt11.visibility = View.GONE
        } else if (playBt12.isPressed) {
            playBt12.visibility = View.VISIBLE
            stopBt12.visibility = View.GONE
        }

    }

    //ESTO ES EL TEXTVIEWER PARA CADA CONTADOR, DE CADA EJERCICIO
    fun setTextTimer() {
        val s = (timer / 1000) % 60
        val format = String.format("%02d", s)

        count1TextView.text = format
        count2TextView.text = format
        count3TextView.text = format
        count4TextView.text = format
        count5TextView.text = format
        count6TextView.text = format
        count7TextView.text = format
        count8TextView.text = format
        count9TextView.text = format
        count10TextView.text = format
        count11TextView.text = format
        count12TextView.text = format

    }

    fun stop() {

        val s = (timer / 1000) % 60
        val format = String.format("%02d", s)

        count1TextView.text = format
        count2TextView.text = format
        count3TextView.text = format
        count4TextView.text = format
        count5TextView.text = format
        count6TextView.text = format
        count7TextView.text = format
        count8TextView.text = format
        count9TextView.text = format
        count10TextView.text = format
        count11TextView.text = format
        count12TextView.text = format

        if (stopBt1.isPressed) {
            playBt1.visibility = View.VISIBLE
            stopBt1.visibility = View.GONE
        } else if (stopBt2.isPressed) {
            playBt2.visibility = View.VISIBLE
            stopBt2.visibility = View.GONE
        } else if (stopBt3.isPressed) {
            playBt3.visibility = View.VISIBLE
            stopBt3.visibility = View.GONE
        } else if (stopBt4.isPressed) {
            playBt4.visibility = View.VISIBLE
            stopBt4.visibility = View.GONE
        } else if (stopBt5.isPressed) {
            playBt5.visibility = View.VISIBLE
            stopBt5.visibility = View.GONE
        } else if (stopBt6.isPressed) {
            playBt6.visibility = View.VISIBLE
            stopBt6.visibility = View.GONE
        } else if (stopBt7.isPressed) {
            playBt7.visibility = View.VISIBLE
            stopBt7.visibility = View.GONE
        } else if (stopBt8.isPressed) {
            playBt8.visibility = View.VISIBLE
            stopBt8.visibility = View.GONE
        } else if (stopBt9.isPressed) {
            playBt9.visibility = View.VISIBLE
            stopBt9.visibility = View.GONE
        } else if (stopBt10.isPressed) {
            playBt10.visibility = View.VISIBLE
            stopBt10.visibility = View.GONE
        } else if (stopBt11.isPressed) {
            playBt11.visibility = View.VISIBLE
            stopBt11.visibility = View.GONE
        } else if (stopBt12.isPressed) {
            playBt12.visibility = View.VISIBLE
            stopBt12.visibility = View.GONE
        }
    }
}






