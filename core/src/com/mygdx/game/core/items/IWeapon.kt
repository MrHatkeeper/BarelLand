package com.mygdx.game.core.items

interface IWeapon {
    val itemTag: ItemTag
    val dmgMin: Int
    val dmgMax: Int
    val chanceToHit: Int
}
