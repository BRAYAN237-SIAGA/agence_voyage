package com.example.siaga

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PostsAdapter(
    var mContext : Context,
    var resource : Int,
    var values : ArrayList<Post>
) : ArrayAdapter<Post>(mContext,resource,values){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val post = values[position]
        val itemView  = LayoutInflater.from(mContext).inflate(resource,parent,false)
        val nom_agences = itemView.findViewById<TextView>(R.id.nom_agences)
        val image_agences = itemView.findViewById<ImageView>(R.id. image_agences)
        val ville_1_depart = itemView.findViewById<TextView>(R.id.ville_1_depart)
        val ville_2_fin = itemView.findViewById<TextView>(R.id.ville_2_fin)
        val quartier_1 = itemView.findViewById<TextView>(R.id.quartier_1)
        val quartier_2 = itemView.findViewById<TextView>(R.id.quartier_2)
        val kilometre = itemView.findViewById<TextView>(R.id.kilometre)

        nom_agences.text =post.nom
        image_agences.setImageResource(post.image)
        ville_1_depart.text = post.ville_1
        ville_2_fin.text = post.ville_2
        quartier_1.text = post.quartier_A
        quartier_2.text = post.quartier_B
        kilometre.text = post.distance

        return itemView
    }

}