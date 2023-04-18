package com.mygdx.game.core.tiles

interface ITile {
    val hasDungeon: Boolean
    val tag: TileTags
    val road: Int
    val startCombat: Int
}
