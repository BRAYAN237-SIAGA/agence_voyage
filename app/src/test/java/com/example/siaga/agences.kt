package com.example.siaga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.brayan.R

class agences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agences)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list_agences = findViewById<ListView>(R.id.list_agences)
        val cardViews = listOf(
            layoutInflater.inflate(R.layout.item_agences,null),
            layoutInflater.inflate(R.layout.item_agences,null),
            layoutInflater.inflate(R.layout.item_agences,null),
            layoutInflater.inflate(R.layout.item_agences,null)
        )
        list_agences.adapter = object : BaseAdapter(){
            override fun getCount(): Int {
                return cardViews.size
            }

            override fun getItem(position: Int): Any {
                return  position
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val cardView = cardViews[position]

                cardView.findViewById<TextView>(R.id.Nom_agence).text = when(position){
                    0 -> "UNITED VOYAGE"
                    1 -> "FINEXS VOYAGE"
                    2 -> "GLOBAL VOYAGE"
                    else -> "TOURISTIQUE VOYAGE"
                }
                cardView.findViewById<TextView>(R.id.Ville_1).text = when(position){
                    0 -> "DOUALA"
                    1 -> "YAOUNDE"
                    2 -> "BANA"
                    else -> "GAROUA"

                }
                cardView.findViewById<TextView>(R.id.Ville_2).text = when(position){
                    0 -> "YAOUNDE"
                    1 -> "DOUALA"
                    2 -> "BAFANG"
                    else -> "MAROUA"
                }
                cardView.findViewById<TextView>(R.id.Device_agence).text = when(position){
                    0 -> "SECURITE - CONFORT"
                    1 -> "SECURITE - RAPIDITE"
                    2 -> "SECURITE - CONFIANCE"
                    else -> "SECURITE - TRAVAIL"
                }

                return cardView
            }
        }
        list_agences.setOnItemClickListener { adapterView, view, position, id ->
            Intent(this, disponibilites::class.java).also {
                startActivity(it)
            }
        }
    }
}