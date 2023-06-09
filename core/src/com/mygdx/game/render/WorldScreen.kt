package com.mygdx.game.render

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.mygdx.game.core.GameWorld
import com.mygdx.game.core.tiles.TileTag


class WorldScreen(gameWorld: GameWorld) : ScreenManager(gameWorld) {
    private var sp: SpriteManager = SpriteManager()
    private var scaleX = 64f
    private var scaleY = 64f
    private var screenCenterY = 0
    private var screenCenterX = 0

    private var playerPositionX = 0f
    private var playerPositionY = 0f

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(100f, 100f, camera)
    override fun create() {
        gameWorld.start()
        camera.zoom += 5

        sp.loadTexture("forest", "tiles/forest.png")
        sp.loadTexture("plain", "tiles/plain.png")
        sp.loadTexture("sea", "tiles/sea.png")
        sp.loadTexture("castle", "tiles/castle.png")
        sp.loadTexture("player", "entities/player/player.png")
    }


    override fun render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f)
        playerPositionX = screenCenterX + gameWorld.player!!.x.toFloat() * scaleX
        playerPositionY = screenCenterY + gameWorld.player!!.y.toFloat() * scaleY

        camera.position.set(
            playerPositionX + sp.textures["player"]!!.width,
            playerPositionY + sp.textures["player"]!!.width,
            0f
        )
        camera.update()

        sp.start(camera)
        gameWorld.update()
        renderMap()

        sp.batch!!.end()
    }

    override fun dispose() = sp.dispose()

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
        screenCenterY = ((Gdx.graphics.height / 2f) - (gameWorld.map.size / 2f) * scaleY).toInt()
        screenCenterX = ((Gdx.graphics.width / 2f) - (gameWorld.map.size / 2f) * scaleX).toInt()
    }

    private fun renderMap() {
        for (column in gameWorld.map.indices) {
            for (row in gameWorld.map[column].indices) {
                sp.batch!!.draw(
                    selectTileToRender(column, row),
                    screenCenterX + column * scaleX,
                    screenCenterY + row * scaleY,
                    scaleX,
                    scaleY
                )
            }
        }
        sp.batch!!.draw(sp.textures["player"], playerPositionX, playerPositionY, scaleX, scaleY)
    }

    private fun selectTileToRender(y: Int, x: Int): Texture {
        return when (gameWorld.map[y][x].tag) {
            TileTag.SEA -> sp.textures["sea"]!!
            TileTag.FOREST -> sp.textures["forest"]!!
            TileTag.PLAIN -> sp.textures["plain"]!!
            TileTag.CASTLE -> sp.textures["castle"]!!
        }
    }
}
