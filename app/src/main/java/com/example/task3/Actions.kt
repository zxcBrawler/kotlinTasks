package com.example.task3


fun addVolume(car: Car, addedVolume : Int){
    if (addedVolume != 0 && car.insideVolume + addedVolume <= car.volume){
        car.insideVolume += addedVolume
        car.trunkState = TrunkState.FULL
    }
    else {
        println("The car has ${car.insideVolume} inside. The max volume is ${car.volume}. You cannot add more than ${car.volume - car.insideVolume}")
    }
}

fun emptyTruck(car: Car){
    if (car.trunkState == TrunkState.FULL){
        car.insideVolume = 0
        car.trunkState = TrunkState.EMPTY
        println("The trunk has been emptied for car ${car.brand}")
    }
}


fun openWindow(car: Car, changeWindowState: WindowState){

    if(car.isWindowOpened == WindowState.OPEN && changeWindowState == WindowState.OPEN) {
        println("The window is already opened for car ${car.brand}")
    }
    else if (car.isWindowOpened == WindowState.CLOSE && changeWindowState == WindowState.CLOSE){
        println("The window is already closed for car ${car.brand}")

    }
    else if (car.isWindowOpened == WindowState.CLOSE && changeWindowState == WindowState.OPEN){
        println("Openning the window")
        car.isWindowOpened = changeWindowState

    }
    else if (car.isWindowOpened == WindowState.OPEN && changeWindowState == WindowState.CLOSE){
        println("Closing the window")
        car.isWindowOpened = changeWindowState
    }

}

fun startEngine (car: Car, changeEngineState: EngineState){
    if(car.isEngineOn == EngineState.START && changeEngineState == EngineState.START) {
        println("The engine is already started for car ${car.brand}")
    }
    else if (car.isEngineOn == EngineState.STOP && changeEngineState == EngineState.STOP){
        println("The engine is already stopped for car ${car.brand}")

    }
    else if (car.isEngineOn == EngineState.STOP && changeEngineState == EngineState.START){
        println("Starting the engine")
        car.isEngineOn = changeEngineState

    }
    else if (car.isEngineOn == EngineState.START && changeEngineState == EngineState.STOP){
        println("Stopping the engine")
        car.isEngineOn = changeEngineState
    }

}
