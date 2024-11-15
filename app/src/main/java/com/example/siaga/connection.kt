package com.example.siaga

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class connection : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    lateinit var email_connection: TextInputLayout
    lateinit var password_connection: TextInputLayout
    lateinit var btn_connection: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_connection)

        auth = Firebase.auth
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        email_connection = findViewById(R.id.email_connection)
        password_connection = findViewById(R.id.password_connection)
        btn_connection = findViewById(R.id.btn_connection)


            // connection a la page d'inscription
        var enregistrer_1 = findViewById<TextView>(R.id.enregistrer_1)
        enregistrer_1.setOnClickListener {
            Intent(this, formulaire::class.java ).also {
                startActivity(it)
            }
        }

        // connection a la page d'accueil
        btn_connection.setOnClickListener{

            email_connection.isErrorEnabled = false
            password_connection.isErrorEnabled = false

            val email = email_connection.editText?.text.toString()
            val password = password_connection.editText?.text.toString()

            if(email.isEmpty() ||  password.isEmpty()){
                if (email.isEmpty()) {
                    email_connection.error = "Email required"
                    email_connection.isErrorEnabled = true
                }
                if (password.isEmpty()) {
                    password_connection.error = "password required"
                    password_connection.isErrorEnabled = true
                }
            }else{
                signIn(email,password)
            }
        }
    }
    fun signIn(email :String,password :String){
        Log.d("signIn","signIn user")

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->

            if (task.isSuccessful) {
                Intent(this, MainActivity::class.java).also {
                    startActivity(it)
                }
                finish()
            } else {
                password_connection.error = "authentification failed"
                email_connection.isErrorEnabled = true
                password_connection.isErrorEnabled = true
            }
        }
    }
}