package com.mygdx.game.core.ai

import com.mygdx.game.core.entities.BodyPartTag
import com.mygdx.game.core.entities.IBodyPart

class AiCombat {
    fun selectPartToAttack(bodyParts: Map<BodyPartTag, IBodyPart>): BodyPartTag{
        val partsToAttack = bodyParts.filter { it.value.actHealth > 0 }.keys.toList()
        return partsToAttack[(partsToAttack.indices).random()]
    }
}
