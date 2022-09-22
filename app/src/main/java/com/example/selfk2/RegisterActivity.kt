package com.example.selfk2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "Registro de usuario"
        auth= FirebaseAuth.getInstance()
    }

    //FUNCION QUE COGE LAS VARIABLES DE MAIL I PASSWORD PARA CREAR EL REGISTRO CON FIREBASE
    fun regist(view: View) {
        val email=emailEditText.text.toString()
        val password=pwEditText.text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    //FUNCION PARA EL onClick DE IR A LA ACTIVIDAD DE LOGIN
    fun goToLogin(view: View) {
        val intent= Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}