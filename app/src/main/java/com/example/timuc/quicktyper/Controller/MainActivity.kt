package com.example.timuc.quicktyper.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.timuc.quicktyper.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun menuPlayBtnClicked(view: View){
        startActivity(Intent(this, CreateUserActivity::class.java))
    }
}
