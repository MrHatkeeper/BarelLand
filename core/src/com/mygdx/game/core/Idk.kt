package com.mygdx.game.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.mygdx.game.core.tiles.ITile
import com.mygdx.game.core.tiles.Tile
import com.mygdx.game.core.tiles.TileTags
import java.util.Random

class Idk {
    private val defaultField = Tile(999, false, TileTags.SEA, 0)
    val map: MutableList<MutableList<Tile>> = MutableList(10) { MutableList(10) { defaultField } }

    fun start() {
        val edge = 1
        for (column in edge until map.size - 1) {
            for (row in edge until map[0].size - 1) {
                map[column][row] = Tile(1, false, TileTags.PLAIN, 10)
            }
        }
        for (column in edge until map.size-1){
            for (row in edge until map.size-1){
                if ((0 until 2).random() == 1) map[column][row] = Tile(2,false, TileTags.FOREST, 30)
            }
        }
    }
}
