package com.example.siaga

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color
import android.widget.Button
import com.example.siaga.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button2 = findViewById<Button>(R.id.button2)
        val button = findViewById<Button>(R.id.button)
        val continuer = findViewById<Button>(R.id.continuer)

            continuer.setOnClickListener {
                Intent(this, choix::class.java).also {
                    startActivity(it)
                }

        }
        button.setOnClickListener {
            if(button.backgroundTintList?.defaultColor == Color.rgb(232,225,225)){
                button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(232,225,225))
                continuer.backgroundTintList = ColorStateList.valueOf(Color.rgb(63,188,38))
                button.backgroundTintList = ColorStateList.valueOf(Color.rgb(63,188,38))

                button2.setOnClickListener {
                    Intent(this,contacts::class.java).also {
                        startActivity(it)
                    }
                }
            }else{
                button.backgroundTintList = ColorStateList.valueOf(Color.rgb(232,225,225))
                continuer.backgroundTintList = ColorStateList.valueOf(Color.rgb(78,117,79))
            }
        }
        button2.setOnClickListener {
            if(button2.backgroundTintList?.defaultColor == Color.rgb(232,225,225)){
                button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(63,188,38))
                continuer.backgroundTintList = ColorStateList.valueOf(Color.rgb(63,188,38))
                button.backgroundTintList = ColorStateList.valueOf(Color.rgb(232,225,225))
            }else{
                button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(232,225,225))
                continuer.backgroundTintList = ColorStateList.valueOf(Color.rgb(78,117,79))
            }
        }
    }
    }