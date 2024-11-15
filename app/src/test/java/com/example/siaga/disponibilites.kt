package com.example.siaga

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.brayan.R

class disponibilites : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_disponiblites)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radioButton1 = findViewById<RadioButton>(R.id.radioButton1)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)
        val radioButton4 = findViewById<RadioButton>(R.id.radioButton4)


        val radioButton5 = findViewById<RadioButton>(R.id.radioButton5)
        val radioButton6 = findViewById<RadioButton>(R.id.radioButton6)
        val radioButton7 = findViewById<RadioButton>(R.id.radioButton7)
        val radioButton8 = findViewById<RadioButton>(R.id.radioButton8)

        val confirmer = findViewById<Button>(R.id.confirmer)

        confirmer.setOnClickListener {
            Intent(this, mode_payement::class.java).also {
                startActivity(it)
            }
        }

        val vip = findViewById<CardView>(R.id.vip)
        val classique = findViewById<CardView>(R.id.classique)
        vip.setOnClickListener {
            if (vip.backgroundTintList?.defaultColor == Color.rgb(232, 225, 225)) {
                classique.backgroundTintList = ColorStateList.valueOf(Color.rgb(232, 225, 225))
                vip.backgroundTintList = ColorStateList.valueOf(Color.rgb(204, 242, 36))
                confirmer.backgroundTintList = ColorStateList.valueOf(Color.rgb(63, 188, 38))
            } else {
                vip.backgroundTintList = ColorStateList.valueOf(Color.rgb(232, 225, 225))
                confirmer.backgroundTintList = ColorStateList.valueOf(Color.rgb(78,117,79))
            }
        }

        classique.setOnClickListener {

            if (classique.backgroundTintList?.defaultColor == Color.rgb(232, 225, 225)) {
                vip.backgroundTintList = ColorStateList.valueOf(Color.rgb(232, 225, 225))
                classique.backgroundTintList = ColorStateList.valueOf(Color.rgb(204, 242, 36))
                confirmer.backgroundTintList = ColorStateList.valueOf(Color.rgb(63, 188, 38))
            } else {
                classique.backgroundTintList = ColorStateList.valueOf(Color.rgb(232, 225, 225))
                confirmer.backgroundTintList = ColorStateList.valueOf(Color.rgb(78,117,79))
            }
        }

        radioButton1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                radioButton2.isChecked = false
                radioButton3.isChecked = false
                radioButton4.isChecked = false
            }else{
                radioButton1.isChecked = false
            }
        }

        radioButton2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                radioButton1.isChecked = false
                radioButton3.isChecked = false
                radioButton4.isChecked = false
            }else{
                radioButton2.isChecked = false
            }
        }

        radioButton3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                radioButton2.isChecked = false
                radioButton1.isChecked = false
                radioButton4.isChecked = false
            }else{
                radioButton3.isChecked = false
            }
        }

        radioButton4.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                radioButton2.isChecked = false
                radioButton3.isChecked = false
                radioButton1.isChecked = false
            }else{
                radioButton4.isChecked = false
            }
        }

    }
}
