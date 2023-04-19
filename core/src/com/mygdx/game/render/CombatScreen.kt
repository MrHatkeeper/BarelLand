package com.mygdx.game.render


import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.mygdx.game.core.GameCombat
import com.mygdx.game.core.GameWorld
import com.mygdx.game.core.entities.enemies.EntityTag
import com.mygdx.game.core.entities.player.Player
import com.mygdx.game.core.tiles.TileTag

class CombatScreen(gameWorld: GameWorld) : ScreenManager(gameWorld) {
    private var sp: SpriteManager = SpriteManager()

    private var scaleX = 128f
    private var scaleY = 128f
    private var combat: GameCombat? = null

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(1920f, 1080f, camera)

    //TODO remove player
    override fun create() {
        combat = GameCombat(Player(), TileTag.FOREST)
        combat!!.startCombat()
        val enemyTexture = sp.enemies[combat!!.enemy!!.tag]
        val bgTexture = sp.backgrounds[combat!!.field]
        sp.loadTexture(enemyTexture!!.first, enemyTexture.second)
        sp.loadTexture("player", "entities/player/player.png")
        sp.loadTexture(bgTexture!!.first, bgTexture.second)
    }

    override fun resize(width: Int, height: Int) {
        viewport.setScreenPosition(width, height)
    }

    override fun render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f)
        sp.start(camera)
        renderBackground()
        renderEntities()
        renderUi()

        sp.batch!!.end()
    }

    private fun renderBackground() {
        sp.batch!!.draw(sp.textures["forest"],0f,0f)
    }

    private fun renderEntities() {

    }

    private fun renderUi() {

    }

    override fun dispose() = sp.dispose()
}
