package com.example.siaga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.R

class inscription_step1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inscription_step1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inscription = findViewById<Button>(R.id.inscription)
        val connecter = findViewById<Button>(R.id.connecter)
        inscription.setOnClickListener {
            Intent(this, formulaire::class.java).also {
                startActivity(it)
            }
        }
        connecter.setOnClickListener {
            Intent(this, connection::class.java).also {
                startActivity(it)
            }
        }
    }
}