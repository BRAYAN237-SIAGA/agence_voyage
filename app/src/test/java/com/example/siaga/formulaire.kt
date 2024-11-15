package com.example.siaga

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.brayan.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class formulaire : AppCompatActivity() {

    lateinit var nom_form: TextInputLayout
    lateinit var email_form: TextInputLayout
    lateinit var password_form: TextInputLayout
    lateinit var password_confirm_form: TextInputLayout
    lateinit var btn_form: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulaire)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // declaration des identifiants
        nom_form = findViewById(R.id.nom_form)
        email_form = findViewById(R.id.email_form)
        password_form = findViewById(R.id.password_form)
        password_confirm_form = findViewById(R.id.password_confirm_form)
        btn_form = findViewById(R.id.btn_form)

        //execution du bouton enregistrement
        btn_form.setOnClickListener {

            nom_form.isErrorEnabled = false
            email_form.isErrorEnabled = false
            password_form.isErrorEnabled = false
            password_confirm_form.isErrorEnabled = false

            val nom = nom_form.editText?.text.toString()
            val email = email_form.editText?.text.toString()
            val password = password_form.editText?.text.toString()
            val password_confirm = password_confirm_form.editText?.text.toString()

            if(nom.isEmpty() || email.isEmpty() ||  password.isEmpty() || password_confirm.isEmpty() ){
                if (nom.isEmpty()) {
                    nom_form.error = "nom required"
                    nom_form.isErrorEnabled = true
                }
                if (email.isEmpty()) {
                    email_form.error = "email required"
                    email_form.isErrorEnabled = true
                }
                if (password.isEmpty()) {
                    password_form.error = "password required"
                    password_form.isErrorEnabled = true
                }
                if (password_confirm.isEmpty()) {
                    password_confirm_form.error = "password confirm required"
                    password_confirm_form.isErrorEnabled = true
                }
            }else{
               signIn(nom,email,password,password_confirm)
            }
        }
    }
    fun signIn(nom :String,email :String ,password :String ,password_confirm :String){
        Log.d("signIn","signIn user")
        if ( nom !="" && email !=""  &&  password != "" && password_confirm !="" ){
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }
    }
}