package com.mygdx.game.core

import com.mygdx.game.core.entities.IEntity
import com.mygdx.game.core.entities.enemies.Enemy
import com.mygdx.game.core.entities.enemies.Eye
import com.mygdx.game.core.entities.player.Player
import com.mygdx.game.core.tiles.Tile
import com.mygdx.game.core.tiles.TileTag
import kotlin.math.roundToInt

class GameCombat(private val player: Player, val field: TileTag) {

    private var onTurn: IEntity = player
    var enemy: IEntity? = enemyConstructor()
    private var attacked: IEntity? = null
    private var hasWon: IEntity? = null

    fun startCombat() {
        val enemy = enemyConstructor() ?: return
        player.updateStats()
        enemy.updateStats()
    }

    fun turn(){
        val attackedPart = onTurn.attack(attacked!!.bodyParts)

        if (doesHitLand(attacked!!)) attacked!!.bodyParts[attackedPart.first]!!.actHealth += attackedPart.second
        if (!attacked!!.isAlive) hasWon = onTurn

        if (onTurn == player) onTurn = enemy!! else player
        if (onTurn == player) attacked = enemy else player
    }

    private fun doesHitLand(attacked: IEntity): Boolean {
        //TODO pak asi nějak víc complex lol
        return (0..100).random() <= attacked.dodgeChance
    }

    private fun enemyConstructor(): IEntity? {
        val enemy = selectEnemy() ?: return null
        enemy.actDmgMax += (enemy.weapon.dmgMax * player.combatScaling).roundToInt()
        enemy.actDmgMin += (enemy.weapon.dmgMin * player.combatScaling).roundToInt()
        enemy.dodgeChance += (enemy.dodgeChance * player.combatScaling).roundToInt()
        return enemy
    }

    private fun selectEnemy(): Enemy? {
        return when (field) {
            TileTag.FOREST -> Eye()
            else -> null
        }
    }
}
