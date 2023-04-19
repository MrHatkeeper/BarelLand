package com.mygdx.game.core.entities.player

import com.mygdx.game.core.InputManager
import com.mygdx.game.core.entities.BodyPart
import com.mygdx.game.core.entities.BodyPartTag
import com.mygdx.game.core.entities.IBodyPart
import com.mygdx.game.core.entities.IEntity
import com.mygdx.game.core.entities.enemies.EntityTag
import com.mygdx.game.core.items.ITrinket
import com.mygdx.game.core.items.player.weapons.Fists
import com.mygdx.game.core.items.IWeapon

class Player : IEntity {
    var x: Int = -1
    var y: Int = -1
    var gold = 0
    var level = 1
    var chanceToCombatMultiplayer = 0.1
    var combatScaling = 1.0
    val im: InputManager = InputManager
    override var trinkets: MutableList<ITrinket> = mutableListOf()
    override val tag: EntityTag = EntityTag.PLAYER
    override var weapon: IWeapon = Fists()
    override var actDmgMin: Int = 0
    override var actDmgMax: Int = 0
    override var dodgeChance: Int = 30
    override var actDodgeChance: Int = 30
    override var isAlive: Boolean = true

    override val bodyParts = mutableMapOf<BodyPartTag, IBodyPart>(
        Pair(BodyPartTag.HEAD, BodyPart(true, 80, 80, null)),
        Pair(BodyPartTag.UPPER_BODY, BodyPart(true, 100, 100, null)),
        Pair(BodyPartTag.LOWER_BODY, BodyPart(true, 100, 100, null)),
        Pair(BodyPartTag.LEFT_ARM, BodyPart(false, 50, 50, null)),
        Pair(BodyPartTag.RIGHT_ARM, BodyPart(false, 50, 50, null)),
        Pair(BodyPartTag.LEFT_LEG, BodyPart(false, 50, 50, null)),
        Pair(BodyPartTag.RIGHT_LEG, BodyPart(false, 50, 50, null))
    )

    override fun attack(enemyBodyParts: Map<BodyPartTag, IBodyPart>): Pair<BodyPartTag, Int> {


        return Pair(BodyPartTag.HEAD, -1)
    }


    override fun updateStats() {
        actDmgMin = weapon.dmgMin
        actDmgMax = weapon.dmgMax
        actDodgeChance = dodgeChance
        trinkets.forEach {
            actDmgMin += it.bonusDmg
            actDmgMax += it.bonusDmg
            dodgeChance += it.bonusDodgeChance
        }
    }
}
