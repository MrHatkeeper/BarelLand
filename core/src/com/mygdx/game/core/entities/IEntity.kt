package com.mygdx.game.core.entities

import com.mygdx.game.core.items.armors.IArmor
import com.mygdx.game.core.items.weapons.IWeapon

interface IEntity {
    var weapon: IWeapon?
    var bodyParts: Map<String,IBodyPart>

    fun attack(entity:IEntity)

}