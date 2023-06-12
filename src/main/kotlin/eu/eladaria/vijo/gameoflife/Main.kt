package eu.eladaria.vijo.gameoflife

import eu.eladaria.vijo.gameoflife.service.LifeService
import eu.eladaria.vijo.gameoflife.view.LifeTerminalView

val lifeTerminalView: LifeTerminalView = LifeTerminalView()

fun main() {
    var running: Boolean = true

    //FIXME: Get beings from user input
    var beings = arrayOf(
        arrayOf(true, false, true),
        arrayOf(false, true, false),
        arrayOf(false, false, false)
    )
    val lifeService: LifeService = LifeService(beings)
    lifeService.startCycle()

    while (running) {
        lifeService.startCycle()
        lifeTerminalView.render(beings = beings)
        Thread.sleep(1000)
    }
}

//TODO: First impl algorithm

//Q: How many rows?, Q: How many columns? - random or provided alive/dead


// Rules for algorithm