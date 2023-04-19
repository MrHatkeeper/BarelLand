package com.mygdx.game.core.items.player.weapons

import com.mygdx.game.core.items.IWeapon
import com.mygdx.game.core.items.ItemTag

class Fists : IWeapon {
    override val itemTag: ItemTag = ItemTag.WEAPON
    override val dmgMin: Int = 1
    override val dmgMax: Int = 10
    override val chanceToHit: Int = 100
}
