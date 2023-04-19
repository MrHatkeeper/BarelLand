package com.mygdx.game.core.entities

import com.mygdx.game.core.items.armors.IArmor

interface IBodyPart {
    var bodyPartTag: BodyPartTag
    var isMainPart: Boolean
    var maxHealth: Int
    var actHealth: Int
    var armor: IArmor?
}