package com.mygdx.game.core.entities

import com.mygdx.game.core.items.IArmor

class BodyPart(
    override var isMainPart: Boolean,
    override var maxHealth: Int,
    override var actHealth: Int,
    override var armor: IArmor?
) : IBodyPart

interface IBodyPart {
    var isMainPart: Boolean
    var maxHealth: Int
    var actHealth: Int
    var armor: IArmor?
}
