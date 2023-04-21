package com.mygdx.game.render


import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.mygdx.game.core.GameCombat
import com.mygdx.game.core.GameWorld
import com.mygdx.game.core.entities.player.Player
import com.mygdx.game.core.tiles.TileTag
import kotlin.math.roundToInt

class CombatScreen(gameWorld: GameWorld) : ScreenManager(gameWorld) {
    private var sp: SpriteManager = SpriteManager()

    private var scaleX = 128f
    private var scaleY = 128f
    private var screenCenterHeight = 0
    private var screenCenterWidth = 0
    private var combat: GameCombat? = null
    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(0f, 0f, camera)

    //TODO remove player
    override fun create() {
        screenCenterHeight = ((Gdx.graphics.height / 2f)).toInt()
        screenCenterWidth = ((Gdx.graphics.width / 2f)).toInt()

        viewport.minWorldWidth = Gdx.graphics.width.toFloat()
        viewport.minWorldHeight = Gdx.graphics.height.toFloat()

        camera.position.set(screenCenterHeight.toFloat(),screenCenterWidth.toFloat(),0f)

        combat = GameCombat(Player(), TileTag.FOREST)
        combat!!.startCombat()
        val enemyTexture = sp.enemies[combat!!.enemy!!.tag]
        sp.loadTexture(enemyTexture!!.first, enemyTexture.second)
        sp.loadTexture("player", "entities/player/player.png")
    }

    override fun render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f)
        sp.start(camera)
        renderBackground()
        renderEntities()
        renderUi()

        camera.update()

        sp.batch!!.end()
    }

    private fun renderBackground() {
    }

    private fun renderEntities() {
        sp.batch!!.draw(sp.textures["player"], 0f, 0f, scaleY, scaleX)
    }

    private fun renderUi() {

    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)

        screenCenterHeight = ((Gdx.graphics.height / 2f)).roundToInt()
        screenCenterWidth = ((Gdx.graphics.width / 2f)).roundToInt()

        camera.position.set(screenCenterWidth.toFloat(),screenCenterHeight.toFloat(),0f)

    }

    override fun dispose() = sp.dispose()
}
