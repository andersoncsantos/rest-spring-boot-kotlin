package br.com.anderson.math

import kotlin.math.sqrt

class MathOperations {

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo
    fun subtraction(numberOne: Double, numberTwo: Double) = numberOne - numberTwo
    fun multiplication(numberOne: Double, numberTwo: Double) = numberOne * numberTwo
    fun division(numberOne: Double, numberTwo: Double) = numberOne / numberTwo
    fun mean(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2
    fun squareRoot(number: Double) = sqrt(number)
}
