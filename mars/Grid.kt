package mars

import mars.constants.validDirections
import mars.constants.validMovements
import mars.utils.*

class Grid(xCoordinate: Int, yCoordinate: Int){
    var xRight = xCoordinate
    var yRight = yCoordinate
    private var isValidGrid = true
    init {
        if(isInvalidCoordinate(xCoordinate) || isInvalidCoordinate(yCoordinate)) {
            isValidGrid = false
        }
        if(isValidGrid){
            marsTiles = arrayOf((0..xCoordinate).toList().toTypedArray(), (0..yCoordinate).toList().toTypedArray())
            xRight = xCoordinate
            yRight = yCoordinate
        }
    }

    fun validateGrid() : Boolean{
        return isValidGrid;
    }

    fun isInvalidCoordinate(coordinate: Int) : Boolean{
        return coordinate < 0 || coordinate > xMax || coordinate > yMax;
    }

    fun isInvalidDirection(direction : Char) : Boolean{
        return !validDirections.contains(direction);
    }

    fun isInvalidMovement(direction : Char) : Boolean{
        return !validMovements.contains(direction);
    }

    fun initCoordinates(xCoordinate : Int, yCoordinate : Int, direction : Char) : Boolean{
        if(isInvalidCoordinate(xCoordinate) || isInvalidCoordinate(yCoordinate) || isInvalidDirection(direction)) {
            return false
        }
        xCurrent = xCoordinate
        yCurrent = yCoordinate
        currentDirection = direction
        return true
    }
}