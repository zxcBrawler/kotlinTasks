package com.example.task1

import java.util.*
import kotlin.math.sqrt


fun main() {

    val scanner  = Scanner(System.`in`)

    println("Choose what do you want to do \n" +
            "1) Solve quadratic equation \n" +
            "2) Find triangle data \n" +
            "3) Find the deposit amount after a certain time in years")

    when (scanner.nextInt()){
        1 -> {
            println("Input first number")
            val a = scanner.nextDouble()
            println("Input second number ")
            val b = scanner.nextDouble()
            println("Input third number ")
            val c = scanner.nextDouble()

            solveEquation(a,b,c)
        }
        2 -> {
            println("Input first side")
            val a = scanner.nextDouble()
            println("Input second side ")
            val b = scanner.nextDouble()

            findTriangleData(a,b)
        }
        3 -> {
            println("Input deposit amount")
            val amount = scanner.nextInt()
            println("Input percent")
            val percent = scanner.nextDouble()
            println("Input year number")
            val year = scanner.nextInt()

            findDepositAmount(amount,percent,year)
        }
        else -> {
            println("Wrong operation")
            main()
        }
    }
}
fun solveEquation(a : Double, b : Double, c : Double) {
    val d = (b*b) - 4 * a * c
    when {
        d < 0 -> println("There are no roots")

        d > 0 -> {
            println("Two roots")
            val x1 = (-b + sqrt(d)) / (2 * a)
            val x2 = (-b - sqrt(d)) / (2 * a)
            println("First root - ${String.format("%.3f", x1)} \nSecond root - ${String.format("%.3f", x2)}")
        }
        else -> {
            val x = (-b)/2*a
            println("One root - ${String.format("%.3f", x)}")
        }
    }
}

fun findTriangleData(a: Double, b: Double){
    val c = sqrt(a * a + b * b)
    val p = (a + b + c)
    val s = sqrt(p / 2 * (p / 2 - a) * (p / 2 - b) * (p / 2 - c))

    println("The hypotenuse of a triangle - ${String.format("%.3f", c)}")
    println("The square of a triangle - ${String.format("%.3f", s)}")
    println("The perimeter of a triangle - ${String.format("%.3f", p)}")
}

fun findDepositAmount(amount: Int, percent: Double, years: Int){
    var result = amount

    for (i in years downTo 1){
        result += ((amount * percent) / 100).toInt()
    }
    println("Deposit amount after $years years - $result")
}