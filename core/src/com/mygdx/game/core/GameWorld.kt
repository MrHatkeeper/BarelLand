package com.mygdx.game.core

import com.badlogic.gdx.Input
import com.mygdx.game.core.entities.player.Player
import com.mygdx.game.core.tiles.Tile
import com.mygdx.game.core.tiles.TileTag
import kotlin.math.roundToInt

class GameWorld(mapSize: Int) {
    private val defaultField = Tile(TileTag.SEA, 0)
    val map: MutableList<MutableList<Tile>> = MutableList(mapSize) { MutableList(mapSize) { defaultField } }
    var player: Player? = null
    private var isSomethingPressed = false

    fun start() {
        player = Player()
        val edge = 1
        for (column in edge until map.size - 1) {
            for (row in edge until map[0].size - 1) {
                if ((0 until 2).random() == 1) map[column][row] = Tile(TileTag.FOREST, 30)
                else map[column][row] = Tile(TileTag.PLAIN, 10)
            }
        }
        map[map.size / 2][(map[0].size / 2)] = Tile(TileTag.CASTLE, 0)
        player!!.x = map[0].size / 2
        player!!.y = map.size / 2
    }

    fun update() {
        move()
    }

    private fun enterCombat() {
        val playerField = map[player!!.y][player!!.x]
        val startCombatChance =
            (playerField.startCombat + (playerField.startCombat * player!!.chanceToCombatMultiplayer).roundToInt()..100).random()
        if (startCombatChance >= 80) {
            val combat = GameCombat(player!!, map[player!!.y][player!!.x].tag)
            combat.startCombat()
            player!!.chanceToCombatMultiplayer = 0.0
        } else player!!.chanceToCombatMultiplayer += 0.1
    }


    private fun move() {
        when (player!!.im.move()) {
            Input.Keys.A -> if (map[player!!.x - 1][player!!.y].tag != TileTag.SEA) player!!.x -= 1
            Input.Keys.D -> if (map[player!!.x + 1][player!!.y].tag != TileTag.SEA) player!!.x += 1
            Input.Keys.W -> if (map[player!!.x][player!!.y + 1].tag != TileTag.SEA) player!!.y += 1
            Input.Keys.S -> if (map[player!!.x][player!!.y - 1].tag != TileTag.SEA) player!!.y -= 1
        }
    }

}
