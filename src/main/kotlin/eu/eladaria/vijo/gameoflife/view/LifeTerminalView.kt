package eu.eladaria.vijo.gameoflife.view

class LifeTerminalView {

    fun render(beings: Array<Array<Boolean>>) {
        for (i in beings) {
            for (j in i) {
                if(j) {
                    print("*")
                } else {
                    print(" ")
                }
            }
            println("")
        }
        println("\n ---")
    }
}