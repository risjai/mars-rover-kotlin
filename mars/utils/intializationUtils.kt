package mars.utils

import mars.constants.NORTH

var marsTiles: Array<Array<Int>>? = null
var xMax : Int = Int.MAX_VALUE
var yMax : Int = Int.MAX_VALUE
var xCurrent : Int = 0
var yCurrent : Int = 0
var isValidGrid = true;
var currentDirection : Char = NORTH

