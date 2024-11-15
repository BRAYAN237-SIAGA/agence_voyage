package com.example.siaga

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class page_chargement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_chargement)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        Handler(Looper.getMainLooper()).postDelayed({

            val auth =Firebase.auth
            val currentUser = auth.currentUser
            if(currentUser != null){
                Intent(this,MainActivity::class.java).also {
                    startActivity(it)
                }
            }
           else{
                Intent(this,inscription_step1::class.java).also {
                    startActivity(it)
                }
           }
            finish()
        },3000)
    }
}