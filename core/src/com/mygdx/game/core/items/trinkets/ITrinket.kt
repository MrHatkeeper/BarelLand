package com.mygdx.game.core.items.trinkets

import com.mygdx.game.core.items.ItemTags

interface ITrinket {
    val itemTag: ItemTags
    val bonusDmg: Int
    val bonusDmgReduction: Int
}
