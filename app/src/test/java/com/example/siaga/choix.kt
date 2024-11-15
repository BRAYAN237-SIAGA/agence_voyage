package com.example.siaga

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle

import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.brayan.R

class choix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choix)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rechercher = findViewById<Button>(R.id.rechercher)
        rechercher.setOnClickListener {
            Intent(this, agences::class.java).also {
                startActivity(it)
            }
        }
        val AR = findViewById<Button>(R.id.AR)
        val AS = findViewById<Button>(R.id.AS)
        AR.setOnClickListener {
            if(AR.backgroundTintList?.defaultColor == Color.rgb(232,225,225)){
                AR.backgroundTintList = ColorStateList.valueOf(Color.rgb(63,188,38))
                AS.backgroundTintList = ColorStateList.valueOf(Color.rgb(232,225,225))
                rechercher.backgroundTintList = ColorStateList.valueOf(Color.rgb(63,188,38))
            }else{
                AR.backgroundTintList = ColorStateList.valueOf(Color.rgb(232,225,225))
                rechercher.backgroundTintList = ColorStateList.valueOf(Color.rgb(78,117,79))
            }
        }
        AS.setOnClickListener {
            if(AS.backgroundTintList?.defaultColor == Color.rgb(232,225,225)){
                AS.backgroundTintList = ColorStateList.valueOf(Color.rgb(63,188,38))
                AR.backgroundTintList = ColorStateList.valueOf(Color.rgb(232,225,225))
                rechercher.backgroundTintList = ColorStateList.valueOf(Color.rgb(63,188,38))
            }else{
                AS.backgroundTintList = ColorStateList.valueOf(Color.rgb(232,225,225))
                rechercher.backgroundTintList = ColorStateList.valueOf(Color.rgb(78,117,79))
            }
        }
    }
}