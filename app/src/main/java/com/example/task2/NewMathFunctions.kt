package com.example.task2

fun main(){
    isEven(2)
    divideByThree(6)
    deleteFromArray()
}

fun isEven(a: Int){
    if (a % 2 == 0) println("The number $a is even")
    else println("The number $a is odd")
}

fun divideByThree(a : Int){
    if (a % 3 == 0) println("The number $a can be divided by 3")
    else println("The number $a cannot be divided by 3")
}
fun deleteFromArray() {
    var i = 1
    var numbers = List(100) { i++ }
    for (number in numbers) {
        if (number % 2 == 0 || number % 3 != 0) {
            numbers -= number
        }
    }
    print(numbers)
}

