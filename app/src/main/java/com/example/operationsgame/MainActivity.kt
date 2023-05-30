package com.example.operationsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun getStarted(view: View) {
        val maxScoreEditText = findViewById<EditText>(R.id.maxscore)
        val maxScore = maxScoreEditText.text.toString()
        val intent = Intent(this,GameScreen::class.java)
        intent.putExtra("maxScore",maxScore)
        startActivity(intent)
    }
}