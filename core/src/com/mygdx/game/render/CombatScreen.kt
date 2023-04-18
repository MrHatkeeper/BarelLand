package com.mygdx.game.render


import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.ScreenUtils
import com.mygdx.game.core.Game

class CombatScreen(game: Game): ScreenManager(game) {
    private var sp: SpriteManager = SpriteManager()

    private var scaleX = 128f
    private var scaleY = 128f

    private val camera = OrthographicCamera()

    override fun create() {
        sp.loadTexture("eye","entities/enemies/eye/eye.png")
        sp.loadTexture("eye","entities/player/player.png")
    }


    override fun render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f)
        sp.start(camera)
        sp.batch!!.end()
    }

    override fun dispose() = sp.dispose()
}
