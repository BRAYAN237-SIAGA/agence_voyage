package com.example.siaga

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.util.SparseArray
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.brayan.R
import com.google.android.material.textfield.TextInputEditText

class online : AppCompatActivity(),View.OnClickListener {

    private  var keyValues = SparseArray<String>()
    var code = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_online)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nu1 = findViewById<TextView>(R.id.nu1)
        val nu2 = findViewById<TextView>(R.id.nu2)
        val nu3 = findViewById<TextView>(R.id.nu3)
        val nu4 = findViewById<TextView>(R.id.nu4)
        val nu5 = findViewById<TextView>(R.id.nu5)
        val nu6 = findViewById<TextView>(R.id.nu6)
        val nu7 = findViewById<TextView>(R.id.nu7)
        val nu8 = findViewById<TextView>(R.id.nu8)
        val nu9 = findViewById<TextView>(R.id.nu9)
        val nu0 = findViewById<TextView>(R.id.nu0)

        val back = findViewById<ImageView>(R.id.back)


        val edittexts = findViewById<EditText>(R.id.edittexts)
        if(Build.VERSION.SDK_INT >=21){
            edittexts.showSoftInputOnFocus = false
        }
        else if(Build.VERSION.SDK_INT >=11){
            edittexts.setRawInputType(InputType.TYPE_CLASS_TEXT)
            edittexts.setTextIsSelectable(true)
        }
        else{
            edittexts.setRawInputType(InputType.TYPE_NULL)
            edittexts.isFocusable = true
        }

        nu1.setOnClickListener(this)
        nu2.setOnClickListener(this)
        nu3.setOnClickListener(this)
        nu4.setOnClickListener(this)
        nu5.setOnClickListener(this)
        nu6.setOnClickListener(this)
        nu7.setOnClickListener(this)
        nu8.setOnClickListener(this)
        nu9.setOnClickListener(this)
        nu0.setOnClickListener(this)

        back.setOnClickListener(this)

        keyValues.put(R.id.nu0,"0")
        keyValues.put(R.id.nu1,"1")
        keyValues.put(R.id.nu2,"2")
        keyValues.put(R.id.nu3,"3")
        keyValues.put(R.id.nu4,"4")
        keyValues.put(R.id.nu5,"5")
        keyValues.put(R.id.nu6,"6")
        keyValues.put(R.id.nu7,"7")
        keyValues.put(R.id.nu8,"8")
        keyValues.put(R.id.nu9,"9")

        back.setOnClickListener{
            var lenght : Int = edittexts.text?.length ?: 0
            if(lenght>0){
                edittexts.text?.delete(lenght-1,lenght)
                code.deleteCharAt(lenght-1)
            }
        }

    }
    override fun onClick(v: View?) {
        var value :String = keyValues.get(v!!.id)
            if (code.length<4){
                val edittexts = findViewById<TextInputEditText>(R.id.edittexts)
                code.append(value)
                edittexts.setText(code)
            }

        val valider =  findViewById<Button>(R.id.VALIDER)
        valider.setOnClickListener {
            Intent(this, recu_agence::class.java).also {
                startActivity(it)
            }
        }
        }
}