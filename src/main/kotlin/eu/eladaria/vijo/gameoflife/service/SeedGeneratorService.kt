package eu.eladaria.vijo.gameoflife.service

import kotlin.random.Random
import kotlin.system.exitProcess

/**
 * Service that leads the player through the generation of the starting seed.
 */
class SeedGeneratorService {
    companion object {
        /**
         * Guides the user through the process of creating a seed.
         */
        fun createSeed(): Array<BooleanArray> {
            val beings: Array<BooleanArray>

            println("Welcome to the Game of Life!")
            println("Would you like to start with a custom generation of cells (if you don't, you'll get a random spread of cells)?")
            val customGameSeed: String = readlnOrNull().toString().lowercase() //Technically should verify this, but if a user inputs something incorrect, we just ignore it and assume they wanted a random seed instead.

            println("Please provide how many rows this seed should have.")
            val rowSize = readLine()?.toInt()
            println("Please provide how many columns this seed should have.")
            val columnSize = readLine()?.toInt()

            //FIXME: Custom seed generation by user
            if (rowSize != null && columnSize != null) {
                beings = if(customGameSeed == "yes" || customGameSeed == "y") {
                    println("Please provide which cells should be alive: 0 = dead, 1 = alive.")
                    arrayOf(
                        booleanArrayOf(false, false, false, false, false),
                        booleanArrayOf(false, false, false, false, false),
                        booleanArrayOf(false, true, true, true, false),
                        booleanArrayOf(false, false, false, false, false),
                        booleanArrayOf(false, false, false, false, false),
                    )

                } else {
                    val rows = Array(rowSize) { BooleanArray(columnSize) }

                    for (i in rows.indices) {
                        for(j in rows[i].indices){
                            rows[i][j] = Random.nextBoolean()
                        }
                    }
                    rows
                }
            }
            else {
                println("Invalid input")
                exitProcess(1)
            }

            return beings
        }
    }
}