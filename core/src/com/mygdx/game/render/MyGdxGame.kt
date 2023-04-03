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
    private var x = 0f
    private var y = 0f
    private var viewport: Viewport? = null
    private var camera: Camera? = null
    private var idk: Idk? = null

    override fun create() {
        sp.loadTexture("img", "badlogic.jpg")
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
        val sizeOfTexture = sp.textures["forest"]!!.width.toFloat()

        for (column in map.indices){
            for (row in map[column].indices){
                when (map[column][row].tag) {
                    TileTags.SEA -> sp.batch!!.draw(sp.textures["sea"],column*sizeOfTexture,row*sizeOfTexture )
                    TileTags.FOREST -> sp.batch!!.draw(sp.textures["forest"],column*sizeOfTexture,row*sizeOfTexture )
                    TileTags.PLAIN -> sp.batch!!.draw(sp.textures["plain"],column*sizeOfTexture,row*sizeOfTexture )
                }
            }
        }
    }
}
