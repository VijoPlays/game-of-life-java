package eu.eladaria.vijo.gameoflife.view

class LifeTerminalView {
    companion object {
        fun render(beings: Array<Array<Boolean>>) {
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