package eu.eladaria.vijo.gameoflife.service

class LifeService(var beings: Array<Array<Boolean>>) {

    val rows = beings.size
    val columns = beings[0].size

    fun startCycle(): Array<Array<Boolean>> {
        //PreviousBeings is a copy of the beings at the start of the current cycle. Beings is thus the next generation and can be modified freely, depending on the values of previousBeings.
        val previousBeings = beings

        return calculateCycle(previousBeings = previousBeings)
    }

    private fun calculateCycle(previousBeings: Array<Array<Boolean>>): Array<Array<Boolean>> {
        for (i in previousBeings.indices) {
            for (j in previousBeings[i].indices) {
                val aliveNeighbours = getAliveNeighbours(previousBeings = previousBeings, rowIndex = i, columnIndex = j)

                if (previousBeings[i][j]) { //Cell is alive algorithm
                    when(aliveNeighbours) {
                        2, 3 -> beings[i][j] = true
                        else -> beings[i][j] = false
                    }
                } else { //Cell is dead algorithm
                    when(aliveNeighbours) {
                        3 -> beings[i][j] = true
                        else -> beings[i][j] = false
                    }
                }
            }
        }
        return beings
    }

    private fun getAliveNeighbours(previousBeings: Array<Array<Boolean>>, rowIndex: Int, columnIndex: Int): Int {
        //TODO: Add failsafe for overflow/underflow

        return 2
    }
}