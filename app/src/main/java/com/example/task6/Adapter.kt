package com.example.task6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task6.Adapter.Holder
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Adapter (private val gamesName: ArrayList<String>,
               private val gamesUrl: ArrayList<String>,
               private val gamesDesc: ArrayList<String>,private var context: Context) :
    RecyclerView.Adapter<Holder>() {

    class Holder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val nameGame : TextView = itemView.findViewById(R.id.name_game)
        val descriptionGame : TextView = itemView.findViewById(R.id.description_game)
        val imageGame : ImageView = itemView.findViewById(R.id.image_game)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       val view : View = LayoutInflater.from(parent.context).inflate(R.layout.games_card, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.nameGame.text = gamesName[position]
        holder.descriptionGame.text = gamesDesc[position]
        Glide.with(this.context)
            .load(gamesUrl[position])
            .into(holder.imageGame)

    }

    override fun getItemCount(): Int {
       return gamesName.size
    }


}


