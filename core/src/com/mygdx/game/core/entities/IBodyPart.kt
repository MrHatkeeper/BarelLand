package com.mygdx.game.core.entities

import com.mygdx.game.core.items.armors.IArmor

interface IBodyPart {
    var bodyPartTag: BodyPartTag
    var maxHealth: Int
    var actHealth: Int
    var armor: IArmor?
}