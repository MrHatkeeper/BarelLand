package com.mygdx.game.core.items.armors

import com.mygdx.game.core.items.ItemTags

interface IArmor {
    val itemTag: ItemTags
    val chanceToReduce: Int
    val reducedDamage: Double
}
