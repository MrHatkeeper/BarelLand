package com.mygdx.game.render

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class SpriteManager {
    var textures = mutableMapOf<String, Texture>()
    var batch: SpriteBatch? = null

    fun loadTexture(name: String, path: String){
        textures[name] = Texture(path)
    }

    fun start(){
        batch = SpriteBatch()
        batch!!.begin()
    }

    fun dispose(){
        batch!!.dispose()
    }
}
