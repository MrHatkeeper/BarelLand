package com.mygdx.game.render

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.mygdx.game.core.Idk
import com.mygdx.game.core.tiles.TileTags


class MyGdxGame : ApplicationAdapter() {
    private var sp: SpriteManager = SpriteManager()
    private var scaleX = 32f
    private var scaleY = 32f
    private var idk: Idk? = null

    override fun create() {
        idk = Idk()
        idk!!.start()
    }

    override fun render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f)
        sp.start()
        renderMap()

        sp.batch!!.end()
    }

    override fun dispose() {
        sp.dispose()
    }


    private fun renderMap() {
        sp.loadTexture("forest", "forest.png")
        sp.loadTexture("plain", "plain.png")
        sp.loadTexture("sea", "sea.png")
        val map = idk!!.map

        for (column in map.indices){
            for (row in map[column].indices){
                when (map[column][row].tag) {
                    TileTags.SEA -> sp.batch!!.draw(sp.textures["sea"],column*scaleX,row*scaleY,scaleX,scaleY )
                    TileTags.FOREST -> sp.batch!!.draw(sp.textures["forest"],column*scaleX,row*scaleY,scaleX,scaleY )
                    TileTags.PLAIN -> sp.batch!!.draw(sp.textures["plain"],column*scaleX,row*scaleY,scaleX,scaleY )
                }
            }
        }
    }
}
