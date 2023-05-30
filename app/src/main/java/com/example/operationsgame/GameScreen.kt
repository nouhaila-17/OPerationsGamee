package com.example.operationsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GameScreen : AppCompatActivity() {
    lateinit var operation: TextView
    lateinit var score: TextView
    lateinit var level: TextView
    lateinit var answer: EditText
    lateinit var submit: Button
    private var currentScore = 0
    private val maxScore = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        operation = findViewById(R.id.operation)
        score = findViewById(R.id.score)
        level = findViewById(R.id.level)
        answer = findViewById(R.id.answer)
        submit = findViewById(R.id.submitAnswer)

        launchGame()


    }

    private fun launchGame() {
        val operation = findViewById<TextView>(R.id.operation)
        val answer = findViewById<EditText>(R.id.answer)
        val submitButton = findViewById<Button>(R.id.submitAnswer)
        val level = findViewById<TextView>(R.id.level)
        val score = findViewById<TextView>(R.id.score)

        var currentOp = Operation.generateOperation()
        operation.text = currentOp.getOperationTemplate()
        level.text = "Level: ${currentOp.getLevel()}"

        var currentScore = 0
        val maxScore = intent.getIntExtra("maxScore",0)

        submitButton.setOnClickListener {
            val userAnswer = answer.text.toString().toIntOrNull()
            if (userAnswer != null) {
                if (userAnswer == currentOp.result()) {
                    currentScore += currentOp.getLevel().IdLevel
                    score.text = "Score: $currentScore"
                    println("Bien joué! Votre score est $currentScore")
                } else {
                    currentScore -= 1
                    score.text = "Score: $currentScore"
                    println("Mauvaise réponse!! $currentOp. Votre score est $currentScore")
                }
                if (currentScore < maxScore) {
                    currentOp = Operation.generateOperation()
                    operation.text = currentOp.getOperationTemplate()
                    level.text = "Level: ${currentOp.getLevel()}"
                } else {
                    println("Le jeu est terminé. Votre score final est $currentScore")
                    answer.isEnabled = false
                    submitButton.isEnabled = false
                    val intent = Intent(this@GameScreen, FinalScreen::class.java)
                    intent.putExtra("finalScore", currentScore)
                    startActivity(intent)
                    finish()
                }
                answer.text.clear()
            }
        }
    }



}

