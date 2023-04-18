package com.mygdx.game.render

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class SpriteManager {
    var textures = mutableMapOf<String, Texture>()
    var batch: SpriteBatch? = null

    fun loadTexture(name: String, path: String){
        textures[name] = Texture(path)
    }

    fun start(camera: Camera){
        batch = SpriteBatch()
        batch!!.begin()
        batch!!.projectionMatrix = camera.combined
    }

    fun dispose(){
        batch!!.dispose()
    }
}
