package com.example.timuc.quicktyper.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.timuc.quicktyper.R
import com.example.timuc.quicktyper.Services.GameService

import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        GameService.findRandomWord(this){complete ->
            if(complete){
                randomWordText.text = GameService.word
            }
        }
    }
}



