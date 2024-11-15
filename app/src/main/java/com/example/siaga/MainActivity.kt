package com.example.siaga

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val acheter = findViewById<Button>(R.id.acheter)
        val reserver = findViewById<Button>(R.id.reserver)
        acheter.setOnClickListener {

            if (acheter.backgroundTintList?.defaultColor == Color.rgb(232, 225, 225)) {
                reserver.backgroundTintList = ColorStateList.valueOf(Color.rgb(232, 225, 225))
                acheter.backgroundTintList = ColorStateList.valueOf(Color.rgb(63, 188, 38))
                Intent(this, HomeActivity::class.java).also {
                    startActivity(it)
                }
            }else {
                acheter.backgroundTintList = ColorStateList.valueOf(Color.rgb(232, 225, 225))
            }
        }

        reserver.setOnClickListener {

            if (reserver.backgroundTintList?.defaultColor == Color.rgb(232, 225, 225)) {
                acheter.backgroundTintList = ColorStateList.valueOf(Color.rgb(232, 225, 225))
                reserver.backgroundTintList = ColorStateList.valueOf(Color.rgb(63, 188, 38))
                Intent(this, HomeActivity::class.java).also {
                    startActivity(it)
            }
            }else{
                reserver.backgroundTintList = ColorStateList.valueOf(Color.rgb(232, 225, 225))
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item_profile ->{
                Intent(this, personne::class.java).also {
                    startActivity(it)
            }
        }
            R.id.item_configuration ->{
                Toast.makeText(this,"it's not ready",Toast.LENGTH_SHORT).show()
            }
            R.id.item_deconnecter ->{
                val auth= Firebase.auth
                auth.signOut()
                Intent(this, inscription_step1::class.java).also {
                    startActivity(it)
                }
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    }