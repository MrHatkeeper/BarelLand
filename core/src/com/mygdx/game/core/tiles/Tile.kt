package com.mygdx.game.core.tiles

class Tile(
    override val movementDifficulty: Int,
    override val hasDungeon: Boolean,
    override val tag: TileTags,
    override val defaultSpawnForEnemy: Int
) : ITile {

}
