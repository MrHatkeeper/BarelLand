package com.mygdx.game.core.items.enemies.weapons

import com.mygdx.game.core.items.IWeapon
import com.mygdx.game.core.items.ItemTag

class EyeWeapon : IWeapon {
    override val itemTag: ItemTag = ItemTag.WEAPON
    override val dmgMin: Int = 10
    override val dmgMax: Int = 20
    override val chanceToHit: Int = 50
}
