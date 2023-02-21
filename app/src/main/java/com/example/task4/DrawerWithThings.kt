package com.example.task4


data class Thing (var name : String, var color : String, var quantity : Int)

val shirt = Thing("Shirt","Black", 12)
val cap = Thing("Cap","Black", 1)
val dress = Thing("Dress","Red", 15)
val skirt = Thing("Skirt","Green", 12)

class Queue <T> (private val array : ArrayList<T>){

    fun findElement(element : T, foundElement : (index : Int, element: T?) -> Unit){
        for (i in array.indices){
            if(array[i] == element){
                return foundElement(i, array[i])
            }
        }
        return foundElement(-1, null)
    }

    fun addElement(element : T){
        array.add(element)
    }

    fun deleteElement(element: T){
        array.remove(element)
    }

    fun printArray(){
        for (item in array)
        println(item)
    }

    fun filterArray( predicate: (T) -> Boolean)  {
        val res = ArrayList<T>()
        for (item in array){
            if (predicate(item)){
                res.add(item)
            }
        }
        return println(res)
  }

}



fun main() {
    val things = Queue(arrayListOf(shirt, cap, dress))

    things.addElement(skirt)

    things.deleteElement(cap)

    things.printArray()

    // prints only black clothes
    things.filterArray { it.color == "Black" }

    // finds index of certain element in array. Returns -1 if not found
    things.findElement(cap){ index, _ -> println("$index") }

}