package com.mygdx.game.core.entities

import com.mygdx.game.core.entities.enemies.EntityTag
import com.mygdx.game.core.items.ITrinket
import com.mygdx.game.core.items.IWeapon
import kotlin.math.roundToInt

interface IEntity {
    val tag: EntityTag
    var weapon: IWeapon
    var actDmgMin:Int
    var actDmgMax: Int
    var dodgeChance: Int
    var actDodgeChance: Int
    var trinkets: MutableList<ITrinket>
    var isAlive: Boolean

    val bodyParts: MutableMap<BodyPartTag, IBodyPart>
    private fun destroyedBodyParts(): Int = bodyParts.values.count { it.actHealth <= 0 }
    private fun destroyedMainBodyParts(): Int = bodyParts.values.count { it.actHealth <= 0 && it.isMainPart }
    fun attack(enemyBodyParts: Map<BodyPartTag, IBodyPart>): Pair<BodyPartTag,Int>
    fun updateStats(){
        actDmgMin = weapon.dmgMin
        actDmgMax = weapon.dmgMax
        actDodgeChance = dodgeChance
        trinkets.forEach {
            actDmgMin += it.bonusDmg
            actDmgMax += it.bonusDmg
            dodgeChance += it.bonusDodgeChance
        }
    }
    fun isAlive() {
        val mainBodyParts = (bodyParts.values.count { it.isMainPart } / 2.0).roundToInt()
        val bodyParts = (bodyParts.values.count { !it.isMainPart } / 2.0).roundToInt()

        if (destroyedMainBodyParts() >= mainBodyParts) isAlive = false
        else if (destroyedBodyParts() > bodyParts) isAlive = false
    }
}
