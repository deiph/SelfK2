package com.example.selfk2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_imc.*

class IMCActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        title = "Calculadora de IMC"

        //HE COGIDO CÓDIGO DE INTERNET QUE CALCULA EL IMC Y LO HE ADAPTADO

        calcBt.setOnClickListener {
        // VALIDAMOS SI HAY DATOS, Y LOS PASAMOS A LAS RESPECTIVAS VARIABLES
        if (alturaEditText.text.isNotEmpty() && pesoEditText.text.isNotEmpty()) {
            val altura = (alturaEditText.text.toString()).toInt()
            val peso = (pesoEditText.text.toString()).toInt()

            //A ESTA VARIABLE, CON LA FUNCION DE CALCULAR IMC, LE DAMOS VALOR
            val iMC = calcIMC(altura, peso)

            imc.text = iMC.toString()
            imc.visibility = View.VISIBLE

            //AÑADIMOS TEXTO AL ESTADO, SEGÚN EL VALOR DEL IMC
            if (iMC < 18.5) {
                estadoTextView.text = "Bajo peso"
            } else if (iMC >= 18.5 && iMC < 24.9) {
                estadoTextView.text = "Normal"
            } else if (iMC >= 24.9 && iMC < 30) {
                estadoTextView.text = "Sobrepeso"
            } else if (iMC >= 30) {
                estadoTextView.text = "Obesidad"
            }

            imcTextView.visibility = View.VISIBLE
            estadoTextView.visibility = View.VISIBLE

            recalcBt.visibility = View.VISIBLE
            calcBt.visibility = View.GONE

        }

        // SI UNO DE LOS DOS VALORES, O LOS DOS, NO TIENEN NADA, SALDRÁ EL TOAST SIGUIENTE
        else {
            Toast.makeText(this, "Por favor, añade un peso y una altura" +
                    " correctos", Toast.LENGTH_SHORT).show()
        }
    }

        //BOTON DE RECALCULAR, QUE RESETEARÁ VALORES TAMBIÉN CON LA FUNCIÓN SIGUIENTE
    recalcBt.setOnClickListener {
        resetearValores()
    }

}

//FUNCION QUE DEJA LOS CAMPOS EN BLANCO
private fun resetearValores() {

    calcBt.visibility = View.VISIBLE
    recalcBt.visibility = View.GONE

    alturaEditText.text.clear()
    pesoEditText.text.clear()
    estadoTextView.text = " "
    imc.text = " "
    imcTextView.visibility = View.GONE
}

    //FUNCION QUE CALCULA EL IMC
    private fun calcIMC(altura: Int, peso: Int): Float {

        val alturaCm = altura.toFloat() / 100

        return peso.toFloat() / (alturaCm * alturaCm)
    }
}