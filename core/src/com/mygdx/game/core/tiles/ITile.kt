package com.mygdx.game.core.tiles

interface ITile {
    val movementDifficulty: Int
    val hasDungeon: Boolean
    val tag: TileTags
    val defaultSpawnForEnemy: Int
}
