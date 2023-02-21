package com.example.task6

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Text
import java.io.IOException
import java.io.InputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    private val gamesName : ArrayList<String> = arrayListOf()
    private val gamesUrl : ArrayList<String> = arrayListOf()
    private val gamesDesc: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(gamesName,gamesUrl,gamesDesc,this)
        recyclerView.adapter = adapter
        recyclerView.hasFixedSize()

        addGames()
    }

    private fun addGames(){
        try {
            val obj : JSONObject = JSONObject(loadJSON())

            val gamesArray : JSONArray = obj.getJSONArray("games")
            for (i in 0 until gamesArray.length()) {
              val gamesDetail : JSONObject = gamesArray.getJSONObject(i)
            gamesName.add(gamesDetail.getString("name"))
            gamesDesc.add(gamesDetail.getString("description"))
            gamesUrl.add(gamesDetail.getString("url"))


            }
        }
        catch (e : IOException){
            e.printStackTrace()
        }

    }

    private fun loadJSON() : String {
        var json: String?
        try {
            val inputStream: InputStream = assets.open("data.json")
            val size : Int = inputStream.available()
            val buffer  = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            json = String(buffer)

        }
        catch (e : IOException){
                e.printStackTrace()
            return null.toString()
        }
        return json
    }
}