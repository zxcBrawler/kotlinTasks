package com.example.task3

data class Car(
    val brand: String,
    val year: Int,
    val volume: Int,
    var isWindowOpened: WindowState,
    var isEngineOn: EngineState,
    var trunkState: TrunkState,
    var insideVolume: Int
)

enum class EngineState {
    START, STOP
}
enum class WindowState {
    OPEN, CLOSE
}
enum class TrunkState {
    FULL, EMPTY
}





