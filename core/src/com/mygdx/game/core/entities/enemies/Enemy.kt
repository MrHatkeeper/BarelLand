package com.mygdx.game.core.entities.enemies

import com.mygdx.game.core.entities.IBodyPart
import com.mygdx.game.core.entities.IEntity
import com.mygdx.game.core.items.weapons.IWeapon

class Enemy(val tag: EnemyTag) : IEntity {
    override var weapon: IWeapon? = null
    override var bodyParts: Map<String, IBodyPart> = mutableMapOf()
    override fun attack(entity: IEntity) {
        TODO("Not yet implemented")
    }

}
