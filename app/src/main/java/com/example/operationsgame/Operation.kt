package com.example.operationsgame

import kotlin.random.Random

interface Operation {
    fun result(): Int
    fun getOperationTemplate(): String
    fun getLevel(): Level
    companion object {
        fun generateOperation(): Operation {
            val level=arrayOf(Level.Easy,Level.Medium,Level.Hard).random()
            val num1 = Random.nextInt(0, 100)
            val num2 = Random.nextInt(0, 100)
            return if (level == Level.Easy) Addition(num1, num2)
            else if (level == Level.Medium) Substraction(num1, num2)
            else  Multiplication(num1, num2)

        }
    }
}