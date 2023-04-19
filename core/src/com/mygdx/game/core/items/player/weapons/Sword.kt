package com.mygdx.game.core.items.player.weapons

import com.mygdx.game.core.items.IWeapon
import com.mygdx.game.core.items.ItemTag

class Sword : IWeapon {
    override val itemTag: ItemTag = ItemTag.WEAPON
    override val dmgMin: Int = 3
    override val dmgMax: Int = 6
    override val chanceToHit: Int = 80
}
