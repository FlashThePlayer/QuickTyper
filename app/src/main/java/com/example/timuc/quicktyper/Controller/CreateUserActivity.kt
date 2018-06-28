package com.example.timuc.quicktyper.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.timuc.quicktyper.R
import com.example.timuc.quicktyper.Services.GameService
import com.example.timuc.quicktyper.Services.UserDataService
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun gameMode1switchIsClicked(view: View){
        if(gameMode1switch.isChecked){
            GameService.gamemode = 1;
            gameMode2switch.isChecked = false
        }
    }

    fun gameMode2switchIsClicked(view: View){
        if(gameMode2switch.isChecked){
            GameService.gamemode = 2;
            gameMode1switch.isChecked = false
        }
    }



   fun startGameBtnClicked(view: View){
       UserDataService.name = userNameLabel.text.toString()

       if(UserDataService.name.isNotEmpty()){
           startActivity(Intent(this, GameActivity::class.java))
       } else
           Toast.makeText(this, "please enter a Username to play a round", Toast.LENGTH_LONG).show()
   }

}
