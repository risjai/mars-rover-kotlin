    package mars

    import mars.constants.*
    import mars.utils.*

    class Rover(g : Grid) {
        val grid = g;
        fun evaluateNewPosition(movement: Char): Boolean {
            if (grid.isInvalidMovement(movement)) {
                return false;
            }
            when (movement) {
                'L' -> processLeftMovement()
                'R' -> processRightMovement()
                'M' -> return processMovement()
            }
            return true;
        }

        private fun processMovement(): Boolean {
            when (currentDirection) {
                NORTH -> {
                    if (grid.isInvalidCoordinate(yCurrent + 1)) return false else yCurrent += 1
                }
                SOUTH -> {
                    if (grid.isInvalidCoordinate(yCurrent - 1)) return false else yCurrent -= 1
                }
                WEST -> {
                    if (grid.isInvalidCoordinate(xCurrent - 1)) return false else xCurrent -= 1
                }
                EAST -> {
                    if (grid.isInvalidCoordinate(xCurrent + 1)) return false else xCurrent += 1
                }
            }
            return true
        }
    }

    fun main() {
        val grid = Grid(5, 5);
        if (!grid.validateGrid()) {
            println("Unable to initialize grid with the provided inputs. Mars mission unsuccessful!")
            return
        }
        grid.initCoordinates(3, 3, EAST)
        var directions: String = "MMRMMRMRRM"
        val iterator = directions.toCharArray().iterator()
        val rover = Rover(grid)
        iterator.forEach lit@{
            if (!rover.evaluateNewPosition(it)) {
                println("Mars mission terminated abruptly")
                return@lit
            }
        }
        println("Your final position is ")
        println("$xCurrent $yCurrent $currentDirection")
    }