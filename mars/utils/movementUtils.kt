package mars.utils

import mars.constants.*

fun processLeftMovement(){
    when(currentDirection){
        NORTH -> currentDirection = WEST
        SOUTH -> currentDirection = EAST
        EAST -> currentDirection = NORTH
        WEST -> currentDirection = SOUTH
    }
}

fun processRightMovement(){
    when(currentDirection){
        NORTH -> currentDirection = EAST
        SOUTH -> currentDirection = WEST
        EAST -> currentDirection = SOUTH
        WEST -> currentDirection = NORTH
    }
}