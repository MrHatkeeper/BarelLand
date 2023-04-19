package com.mygdx.game.render

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.core.entities.enemies.EntityTag
import com.mygdx.game.core.tiles.TileTag

class SpriteManager {
    var textures = mutableMapOf<String, Texture>()

    var enemies: Map<EntityTag, Pair<String, String>> = mapOf(
        Pair(EntityTag.EYE, Pair("eye", "entities/enemies/eye/Eye.png"))
    )

    var backgrounds: Map<TileTag, Pair<String, String>> = mapOf(
        Pair(TileTag.FOREST, Pair("forest", "backgrounds/backgroundForest.png"))
    )

    var batch: SpriteBatch? = null

    fun loadTexture(name: String, path: String) {
        textures[name] = Texture(path)
    }

    fun start(camera: Camera) {
        batch = SpriteBatch()
        batch!!.begin()
        batch!!.projectionMatrix = camera.combined
    }

    fun dispose() {
        batch!!.dispose()
    }
}
