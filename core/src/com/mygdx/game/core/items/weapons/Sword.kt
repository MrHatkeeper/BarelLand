package com.mygdx.game.core.items.weapons

import com.mygdx.game.core.items.ItemTags

class Sword : IWeapon {
    override val itemTag: ItemTags = ItemTags.WEAPON
    override val damageMin: Int = 3
    override val damageMax: Int = 6
}
