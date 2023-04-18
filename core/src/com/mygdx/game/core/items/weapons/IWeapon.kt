package com.mygdx.game.core.items.weapons

import com.mygdx.game.core.items.ItemTags

interface IWeapon {
    val itemTag: ItemTags
    val damageMin: Int
    val damageMax: Int
}
