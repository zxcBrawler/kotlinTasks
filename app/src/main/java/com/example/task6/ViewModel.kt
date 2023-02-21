package com.example.task6

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task1.main
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.security.AccessController.getContext

lateinit var games : ArrayList<Games>
class ViewModel : ViewModel() {

    var  liveData : MutableLiveData<MutableList<Games>> = MutableLiveData()

    fun getLiveDataObserver() : MutableLiveData<MutableList<Games>>{

        return liveData
    }


    fun addGames(){
        try {
            val obj : JSONObject = JSONObject(loadJSON())
            games = arrayListOf()
            val gamesArray : JSONArray = obj.getJSONArray("games")
            for (i in 0 until gamesArray.length()) {
                val gamesDetail : JSONObject = gamesArray.getJSONObject(i)
                games.add((Games(gamesDetail.getString("name"),
                    gamesDetail.getString("url"),
                    gamesDetail.getString("description"))))

            }
            liveData.postValue(games)
        }
        catch (e : IOException){
            e.printStackTrace()
        }
    }

    private fun loadJSON() : String {
        var json: String?
        try {
           val inputStream: InputStream = MainActivity.getContext()!!.assets.open("data.json")
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