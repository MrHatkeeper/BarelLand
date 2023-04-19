package com.mygdx.game.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.mygdx.game.core.entities.player.Player
import com.mygdx.game.core.tiles.Tile
import com.mygdx.game.core.tiles.TileTags
import kotlin.math.roundToInt

class GameWorld(mapSize: Int) {
    private val defaultField = Tile(TileTags.SEA, 0)
    val map: MutableList<MutableList<Tile>> = MutableList(mapSize) { MutableList(mapSize) { defaultField } }
    var player: Player? = null
    private var isSomethingPressed = false

    fun start() {
        player = Player()
        val edge = 1
        for (column in edge until map.size - 1) {
            for (row in edge until map[0].size - 1) {
                if ((0 until 2).random() == 1) map[column][row] = Tile(TileTags.FOREST, 30)
                else map[column][row] = Tile(TileTags.PLAIN, 10)
            }
        }
        map[map.size / 2][(map[0].size / 2)] = Tile(TileTags.CASTLE, 0)
        player!!.x = map[0].size / 2
        player!!.y = map.size / 2
    }

    fun update() {
        move()
    }

    private fun enterCombat() {
        val playerField = map[player!!.y][player!!.x]
        val startCombatChance =
            (playerField.startCombat + (playerField.startCombat * player!!.chanceMultiplayer).roundToInt()..100).random()
        if (startCombatChance >= 80) {
            val combat = GameCombat(player!!, map)
            combat.startCombat()
            player!!.chanceMultiplayer = 0.0
        } else player!!.chanceMultiplayer += 0.1
    }


    private fun move() {
        if (!isSomethingPressed) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                if (map[player!!.x - 1][player!!.y].tag != TileTags.SEA) player!!.x -= 1
                isSomethingPressed = true
                enterCombat()
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                if (map[player!!.x + 1][player!!.y].tag != TileTags.SEA) player!!.x += 1
                isSomethingPressed = true
                enterCombat()
            } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (map[player!!.x][player!!.y + 1].tag != TileTags.SEA) player!!.y += 1
                isSomethingPressed = true
                enterCombat()
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                if (map[player!!.x][player!!.y - 1].tag != TileTags.SEA) player!!.y -= 1
                isSomethingPressed = true
                enterCombat()
            }
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) isSomethingPressed = false
    }

}
