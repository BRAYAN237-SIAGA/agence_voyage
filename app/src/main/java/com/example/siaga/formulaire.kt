package com.example.siaga

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class formulaire : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    lateinit var nom_form: TextInputLayout
    lateinit var email_form: TextInputLayout
    lateinit var password_form: TextInputLayout
    lateinit var password_confirm_form: TextInputLayout
    lateinit var btn_form: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulaire)

        auth = Firebase.auth

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

           initErrors()

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
               if(password != password_confirm){
                   password_confirm_form.error = "password did not march"
                   password_confirm_form.isErrorEnabled = true
               }else{
                   auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{task ->
                       if(task.isSuccessful){
                           val user = hashMapOf(
                               "fullname" to nom,
                               "email" to email
                           )
                           val currentUser = auth.currentUser
                           val db = Firebase.firestore
                           db.collection("users").document(currentUser!!.uid).set(user).addOnSuccessListener {
                               Intent(this,MainActivity::class.java).also {
                                   startActivity(it)
                               }

                           }.addOnFailureListener{
                               password_confirm_form.error = "error occured please try again late"
                               password_confirm_form.isErrorEnabled = true
                           }
                       }else{
                           password_confirm_form.error = "error occured please try again late"
                           password_confirm_form.isErrorEnabled = true
                       }
                   }
               }
            }
        }
    }
  private fun initErrors(){
      nom_form.isErrorEnabled = false
      email_form.isErrorEnabled = false
      password_form.isErrorEnabled = false
      password_confirm_form.isErrorEnabled = false
  }
}