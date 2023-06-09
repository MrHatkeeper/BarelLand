package com.mygdx.game.core.tiles

class Tile(
    override val tag: TileTag,
    override val startCombat: Int
) : ITile {
    override val hasDungeon: Boolean = false
    override val road: Int = -1
}
