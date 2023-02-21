package com.example.task3

var car1 = Car("Audi",2004,200, WindowState.OPEN, EngineState.STOP, TrunkState.FULL, 23)
var car2 = Car("Toyota",1999,300, WindowState.CLOSE, EngineState.START, TrunkState.EMPTY, 0)

var listOfCars = arrayListOf(car1, car2)


fun main(){
    openWindow(car1, WindowState.CLOSE)
    startEngine(car2, EngineState.STOP)
    emptyTruck(car1)
    addVolume(car2, 122)
   for (i in listOfCars){
       println(i)
   }
}

