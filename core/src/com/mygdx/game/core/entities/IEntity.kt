package com.mygdx.game.core.entities

import com.mygdx.game.core.items.weapons.IWeapon

interface IEntity {
    var weapon: IWeapon?
    var bodyParts: Map<String, IBodyPart>
    fun attack(entity: IEntity)

    fun destroyedBodyParts(): Int = bodyParts.values.count { it.actHealth <= 0 }
    fun destroyedMainBodyParts(): Int = bodyParts.values.count{it.actHealth <= 0 && it.isMainPart}

}