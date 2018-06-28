package com.example.timuc.quicktyper.Services

import android.content.Context
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.timuc.quicktyper.Utilities.FIND_WORD_URL
import org.json.JSONException
import java.util.*

object GameService {

    var gamemode = 1 //default gamemode
    var word = ""



    fun findRandomWord(context: Context, complete: (Boolean) -> Unit){
        val randomChar = getRandomChar()
        var responseWord = ""
        println(randomChar) //<---- TESTING

        val randomWordRequest = object : JsonObjectRequest(Method.GET,  "$FIND_WORD_URL$randomChar", null, Response.Listener { response ->
            try {
                println(response.toString()) //<---- TESTING
                responseWord = response.getString("word")
                complete(true)
            }catch (e: JSONException){
                Log.d("JSON", "EXC:  ${e.localizedMessage}")
            }
        }, Response.ErrorListener { error ->
            Log.d ("ERROR", "Could not get a Randomword: $error")
            complete(false)
        }){
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }
        }

        Volley.newRequestQueue(context).add(randomWordRequest)
        word = responseWord.replaceRange(1, responseWord.length, "...")
        println(word) //<---- TESTING

    }

    private fun getRandomChar(): Char {
        val alphabet ="abcdefghijklmnopqrstuvwxyz"
        val rnd = Random().nextInt(alphabet.length)
        return alphabet.get(rnd)

    }

    private fun cutWord(){

    }

}