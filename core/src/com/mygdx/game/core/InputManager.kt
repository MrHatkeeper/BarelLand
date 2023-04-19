package com.mygdx.game.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input

object InputManager {
    private var isSomethingPressed = false
    fun move(): Int {
        if (!isSomethingPressed) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                isSomethingPressed = true
                return Input.Keys.A
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                isSomethingPressed = true
                return Input.Keys.D
            } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                isSomethingPressed = true
                return Input.Keys.W
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                isSomethingPressed = true
                return Input.Keys.S
            }
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) isSomethingPressed = false
        return -1
    }

    fun selectPartToAttack(){

    }
}
