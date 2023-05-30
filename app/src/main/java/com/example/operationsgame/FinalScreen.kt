package com.example.operationsgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalScreen : AppCompatActivity() {
    lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_screen)

        scoreTextView = findViewById(R.id.scoreTextView)

        val finalScore = intent.getIntExtra("finalScore", 0)
        scoreTextView.text = "Final Score: $finalScore"
    }


}