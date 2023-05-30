package com.example.operationsgame

class Addition(override var num1: Int, override var num2: Int) : Operation {
    override fun result() = num1 + num2
    override fun getOperationTemplate() = "$num1 + $num2"
    override fun getLevel() = Level.Easy
    override fun toString() = "$num1 + $num2 = ${result()}"
}
