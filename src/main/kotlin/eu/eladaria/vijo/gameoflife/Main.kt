package eu.eladaria.vijo.gameoflife

import eu.eladaria.vijo.gameoflife.service.LifeService
import eu.eladaria.vijo.gameoflife.view.LifeTerminalView

fun main() {
    //FIXME: Get beings from user input instead of hard code here
    var beings = arrayOf(
        arrayOf(true, false, true),
        arrayOf(false, true, false),
        arrayOf(false, false, false)
    )
    val lifeService = LifeService(beings)

//TODO: Ask user: How many rows?, : How many columns?;  Random spread of cells or let user give alive/dead
    while (true) {
        LifeTerminalView.render(beings = beings)
        beings = lifeService.startCycle()
        Thread.sleep(1000)
    }
}

//TODO: Comments/README
// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
