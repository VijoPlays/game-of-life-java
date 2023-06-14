package eu.eladaria.vijo.gameoflife.service

/**
 * Service that can start and manipulate the cycles in the Game of Life.
 */
class LifeService(private var beings: Array<BooleanArray>) {

    val rowCount = beings.size
    val columnCount = beings[0].size

    /**
     * Starts 1 cycle of the Game of Life and returns the new generation of cells.
     */
    fun startCycle(): Array<BooleanArray> {
        //PreviousBeings is a copy of the beings at the start of the current cycle. Beings is thus the next generation and can be modified freely, depending on the values of previousBeings.
        val previousBeings = Array(beings.size) { beings[it].copyOf() }

        return calculateCycle(previousBeings = previousBeings)
    }

    private fun calculateCycle(previousBeings: Array<BooleanArray>): Array<BooleanArray> {
        for (i in previousBeings.indices) {
            for (j in previousBeings[i].indices) {
                val aliveNeighbours = getAliveNeighbours(previousBeings = previousBeings, rowIndex = i, columnIndex = j)

                if (previousBeings[i][j]) { //"Cell is alive"-algorithm
                    when(aliveNeighbours) {
                        2, 3 -> beings[i][j] = true
                        else -> beings[i][j] = false
                    }
                } else { //"Cell is dead"-algorithm
                    when(aliveNeighbours) {
                        3 -> beings[i][j] = true
                        else -> beings[i][j] = false
                    }
                }
            }
        }
        return beings
    }

    private fun getAliveNeighbours(previousBeings: Array<BooleanArray>, rowIndex: Int, columnIndex: Int): Int {
        var aliveNeighbours = 0

        for(i in -1..1) {
            for(j in -1..1) {

                //Failsafe for i: Cells at the edge of screen will know cell at other side of screen.
                var x = rowIndex + i
                if(x < 0) {
                    x = rowCount - 1
                } else if (x > rowCount - 1) {
                    x = 0
                }

                //Failsafe for j: Cells at the edge of screen will know cell at other side of screen.
                var y = columnIndex + j
                if(y < 0) {
                    y = columnCount - 1
                } else if (y > columnCount - 1) {
                    y = 0
                }

                if(previousBeings[x][y]) {
                    aliveNeighbours += 1
                }
            }
        }

        //If the cell itself is alive, subtract it from the aliveNeighbours count again
        if (previousBeings[rowIndex][columnIndex]) {
            aliveNeighbours -= 1
        }

        return aliveNeighbours
    }
}