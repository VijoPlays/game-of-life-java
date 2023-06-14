package eu.eladaria.vijo.gameoflife

import eu.eladaria.vijo.gameoflife.service.LifeService
import eu.eladaria.vijo.gameoflife.service.SeedGeneratorService
import eu.eladaria.vijo.gameoflife.view.LifeTerminalView

fun main() {
    var beings = SeedGeneratorService.createSeed()

    val lifeService = LifeService(beings)

    while (true) {
        LifeTerminalView.render(beings = beings)
        beings = lifeService.startCycle()
        Thread.sleep(1000)
    }
}
