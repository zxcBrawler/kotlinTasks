package com.example.task5

data class Product(var name : String, var price : Double, var quantity : Int)
data class Card(var number : Int, var balance : Double, var cardState: CardState)

var card123 = Card(123,3000.0, CardState.ENOUGH_FUNDS)
var milk = Product("Milk",12.5, 5)
var bread = Product("Bread",35.0, 2)

var productsList = arrayListOf(milk, bread)
enum class CardState {
    NOT_ENOUGH_FUNDS,
    ENOUGH_FUNDS,
    BLOCKED
}

fun addMoney(card: Card, sum :Double){
    if (card.cardState == CardState.BLOCKED) {
        throw Exception("Your card is blocked")
    }
    else {
        if (sum > 0 ) {
            card.balance += sum
            println(card.balance)
        }
        else {
            throw Exception("Sum cannot be less than 0")
        }
    }

}

fun checkCardState(card : Card){
    if (card.balance > 0 && card.cardState != CardState.BLOCKED){
        card.cardState = CardState.ENOUGH_FUNDS
        println("Your balance is - ${card.balance}")
    }
    else if (card.cardState == CardState.BLOCKED) {

        throw Exception("Your card is blocked")
    }
   else{
        card.cardState = CardState.NOT_ENOUGH_FUNDS
       throw Exception("not enough money - ${card.balance}")
    }
}



fun buyProduct(card: Card, product: Product, quantity: Int)
{
    if (product.quantity < quantity) {
        throw Exception("you cannot buy more than there is")
    }
    else {
        if (card.balance > product.price && card.cardState != CardState.BLOCKED) {

            card.balance = card.balance - product.price * quantity
            product.quantity -= quantity
            println("You bought $quantity piece(s)")
            checkCardState(card)

        }
        else {
            println(checkCardState(card))
        }
    }
}



fun main(){

    println("Welcome to our shop. These are our products")
    for (item in productsList){
        println(item.name + " Price per one - " + item.price + " Quantity - " + item.quantity)
    }

    try {
        addMoney(card123, 10.0)
    }
    catch(e : Exception){
        println(e)
    }
    try {
        checkCardState(card123)
    }
    catch(e : Exception){
        println(e)
    }
    try {
        buyProduct(card123, bread,1)
    }
    catch(e : Exception){
        println(e)
    }
}



