package com.mygdx.game.core.tiles

interface ITile {
    val hasDungeon: Boolean
    val tag: TileTag
    val road: Int
    val startCombat: Int
}
