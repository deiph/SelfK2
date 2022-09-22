package com.example.selfk2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.selfk2.database.App
import com.example.selfk2.database.HistorialEntity
import com.example.selfk2.databinding.ActivityHistorialBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HistorialActivity : AppCompatActivity() {

    lateinit var binding:ActivityHistorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistorialBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        title ="Registro de actividad"

        lifecycleScope.launch{
            val Historial: List<HistorialEntity> = withContext(Dispatchers.IO){
                App.getDb().HistorialDao().findAll()
            }
            binding.tv1.text = Historial.toString()
        }
        


    }

}