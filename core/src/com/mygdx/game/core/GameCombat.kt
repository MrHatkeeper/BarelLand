package com.mygdx.game.core

import com.mygdx.game.core.entities.enemies.Enemy
import com.mygdx.game.core.entities.enemies.EnemyTag
import com.mygdx.game.core.entities.player.Player
import com.mygdx.game.core.tiles.Tile
import com.mygdx.game.core.tiles.TileTags

class GameCombat(private val player: Player, private val map: MutableList<MutableList<Tile>>) {

    fun startCombat() {
        val enemy = enemyConstructor()

    }

    private fun enemyConstructor(): Enemy? {
        val enemy = selectEnemy() ?: return null


        return null
    }

    private fun selectEnemy(): Enemy?{
        return when(map[player.y][player.x].tag){
            TileTags.FOREST -> Enemy(EnemyTag.EYE)
            else -> null
        }
    }
}