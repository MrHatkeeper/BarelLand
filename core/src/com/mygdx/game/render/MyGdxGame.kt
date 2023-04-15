package com.mygdx.game.render

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.ScreenUtils
import com.mygdx.game.core.tiles.Main
import kotlin.math.roundToInt


class MyGdxGame : ApplicationAdapter() {
    private var sp: SpriteManager = SpriteManager()
    private val main = Main()
    override fun create() {
        main.start()
        sp.loadTexture("background", "level/background.png")
        sp.loadTexture("blob", "characters/friendly/Potato.png")
    }

    override fun render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f)
        sp.start()
        renderBackground()

        sp.batch!!.end()

    }

    override fun dispose() {
        sp.dispose()
    }


    private fun renderBackground() {
        for (x in 0..Gdx.graphics.width step 128) {
            for (y in 0..Gdx.graphics.height step 128) {
                sp.batch!!.draw(
                    sp.textures["background"],
                    x.toFloat(),
                    y.toFloat(),
                    128f,
                    128f
                )
            }
        }
    }
}
