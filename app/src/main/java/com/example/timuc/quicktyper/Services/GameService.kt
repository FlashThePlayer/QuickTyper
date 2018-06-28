package com.example.timuc.quicktyper.Services

import android.content.Context
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.timuc.quicktyper.Utilities.BOARDCAST_GAME_START
import com.example.timuc.quicktyper.Utilities.FIND_WORD_URL
import org.json.JSONArray
import org.json.JSONException
import java.util.*

object GameService {

    var gamemode = 1 //default gamemode
    var word = ""



    fun findRandomWord(context: Context, complete: (Boolean) -> Unit){

        var randomWord = getRandomChar() + "???"
        println(randomWord)

        val randomWordRequest = object : JsonArrayRequest(Method.GET, "$FIND_WORD_URL$randomWord", null, Response.Listener<JSONArray> {response ->
            try {

                var tmpJson = response.getJSONObject(Random().nextInt(response.length()))
                var tmp = tmpJson.getString("word")
                word = tmp.replaceRange(1, tmp.length, "...")
                complete(true)

            }catch (e : JSONException){
                Log.d("JSON", "EXC: " + e.localizedMessage)
            }

        }, Response.ErrorListener { error ->
            Log.d("ERROR", "Could not find user: $error")
            complete(false)
        }){
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }
            }

            Volley.newRequestQueue(context).add(randomWordRequest)
        }

    private fun getRandomChar(): Char {
        val alphabet ="abcdefghijklmnopqrstuvwxyz"
        val rnd = Random().nextInt(alphabet.length)
        return alphabet.get(rnd)

    }

    }