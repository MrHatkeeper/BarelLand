package com.mygdx.game

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.mygdx.game.core.GameCombat
import com.mygdx.game.core.GameWorld
import com.mygdx.game.core.InputManager
import com.mygdx.game.render.CombatScreen
import com.mygdx.game.render.WorldScreen

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
fun main() {
    val config = Lwjgl3ApplicationConfiguration()
    config.setForegroundFPS(60)
    config.setTitle("Gameska")
    Lwjgl3Application(CombatScreen(GameWorld(11)), config)
}
