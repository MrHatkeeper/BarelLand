package com.mygdx.game.render

import com.badlogic.gdx.Game
import com.badlogic.gdx.utils.ScreenUtils

class CombatScreen: Game() {
    private var sp: SpriteManager = SpriteManager()
    private var scaleX = 64f
    private var scaleY = 64f
    override fun create() {
        TODO("Not yet implemented")
    }


    override fun render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f)
        //sp.start()
        sp.batch!!.end()
    }

    override fun dispose() = sp.dispose()
}
