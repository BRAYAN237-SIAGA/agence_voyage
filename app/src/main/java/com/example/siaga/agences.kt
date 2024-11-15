package com.example.siaga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siaga.R

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
         val postsArray = arrayListOf(
             Post("FINEXS VOYAGE","DOUALA","YAOUNDE","AKWA","MVAN","237,3 KM",R.drawable.finexs),
             Post("BUCAVOYAGE","DOUALA","YAOUNDE","BONABERI","MVAN","237,3 KM",R.drawable.buca),
             Post("GENERAL VOYAGE","DOUALA","YAOUNDE","MBOPPI","MVAN","237,3 KM",R.drawable.general),
             Post("GLOBAL VOYAGE","DOUALA","YAOUNDE","VILLAGE","MVAN","237,3 KM",R.drawable.global),
             Post("MEN TRAVEL","DOUALA","YAOUNDE","SADI","NYLON BASTOS","237,3 KM",R.drawable.men),
             Post("TOURISTIQUE VOYAGE","DOUALA","YAOUNDE","AKWA","MVAN","237,3 KM",R.drawable.touristique),
             Post("UNITED TRAVELS","DOUALA","YAOUNDE","AKWA","MVAN","237,3 KM",R.drawable.united),
         )
        val adapter = PostsAdapter(this,R.layout.item_agences,postsArray)
        list_agences.adapter = adapter

        list_agences.setOnItemClickListener { adapterView, view, position, id ->
            val clickedPost = postsArray[position]
            Intent(this,disponibilites::class.java).also {
                it.putExtra("nom",clickedPost.nom)
                startActivity(it)
            }
        }
    }
}