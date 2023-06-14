package eu.eladaria.vijo.gameoflife.view

/**
 * Simple View class that displays living and dead cells.
 */
class LifeTerminalView {
    companion object {
        /**
         * Renders the beings as 1 = alive, and 0 = dead.
         */
        fun render(beings: Array<BooleanArray>) {
            for (i in beings) {
                for (j in i) {
                    if(j) {
                        print("1")
                    } else {
                        print("0")
                    }
                }
                println("")
            }
            println("\n ---")
        }
    }
}