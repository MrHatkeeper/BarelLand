package com.mygdx.game.core.entities.enemies

import com.mygdx.game.core.ai.AiCombat
import com.mygdx.game.core.entities.BodyPartTag
import com.mygdx.game.core.entities.IBodyPart
import com.mygdx.game.core.entities.IEntity
import com.mygdx.game.core.entities.player.Player
import com.mygdx.game.core.items.ITrinket
import com.mygdx.game.core.items.IWeapon

abstract class Enemy(
    override val tag: EntityTag,
    override var dodgeChance: Int,
    override var weapon: IWeapon
) : IEntity {
    override var isAlive: Boolean = true
    override var actDmgMax: Int = 0
    override var actDmgMin: Int = 0
    override var actDodgeChance: Int = 0
    override var trinkets: MutableList<ITrinket> = mutableListOf()
    private val ai = AiCombat()

    override val bodyParts = mutableMapOf<BodyPartTag, IBodyPart>()
    override fun attack(enemyBodyParts: Map<BodyPartTag, IBodyPart>): Pair<BodyPartTag, Int> {
        return Pair(ai.selectPartToAttack(enemyBodyParts),(actDmgMin..actDmgMax).random())
    }

}
