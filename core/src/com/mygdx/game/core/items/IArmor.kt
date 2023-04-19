package com.mygdx.game.core.items

import com.mygdx.game.core.entities.BodyPartTag

interface IArmor {
    val itemTag: ItemTag
    val chanceToReduce: Int
    val reducedDamage: Double
    val dodgeChance: Int
    val bodyPartArmor: BodyPartTag
}
