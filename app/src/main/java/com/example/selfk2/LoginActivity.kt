package com.example.selfk2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "Login"
        auth= FirebaseAuth.getInstance()
    }

    //FUNCION PARA LOGEAR A TRAVÉS DE EMAIL POR FIREBASE, PARA ACCEDER A LOS ENTRENAMIENTOS
    //DEL USUARIO EN CONCRETO, Y SU HISTORIAL

    fun login(view: View) {
        val email=emailEditText.text.toString()
        val password=pwEditText.text.toString()

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent= Intent(this,MainActivity::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    //FUNCION QUE TE DA ACCESO A LA ACTIVIDAD DE REGISTRO, POR SI NO TIENES USUARIO CREADO
    fun goToRegister(view: View) {
        val intent= Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }

}