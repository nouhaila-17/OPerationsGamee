package com.example.operationsgame

class Substraction(var num1: Int, var num2: Int) : Operation {
    override fun result() = num1 - num2
    override fun getOperationTemplate() = "$num1 - $num2"
    override fun getLevel() = Level.Medium
    override fun toString() = "$num1 - $num2 = ${result()}"
}
