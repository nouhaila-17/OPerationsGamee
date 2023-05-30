package com.example.operationsgame

class Multiplication(override var num1: Int, override var num2: Int) : Operation {
    override fun result() = num1 * num2
    override fun getOperationTemplate() = "$num1 x $num2"
    override fun getLevel() = Level.Hard
    override fun toString() = "$num1 x $num2 = ${result()}"
}
