package com.mygdx.game.core.entities.player

import com.mygdx.game.core.items.armors.IArmor
import com.mygdx.game.core.items.trinkets.ITrinket
import com.mygdx.game.core.items.weapons.IWeapon

class Player {
    var x: Int = -1
    var y: Int = -1
    var maxHealth = 20
    var actHealth = maxHealth
    var gold = 0
    var weapon: IWeapon? = null
    var armor: IArmor? = null
    var trinkets: List<ITrinket> = mutableListOf()
    var chanceMultiplayer = 0.1
}
