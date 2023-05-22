package gds

import battle.entity.AbstractEntity
import battle.entity.AbstractEntityNode
import godot.core.Dictionary
import godot.core.dictionaryOf

internal object GodotDataFactory {
    fun newBattleAction(actor: AbstractEntity<out AbstractEntityNode>): Dictionary<String, Int> {
        if (!actor.playerSide) throw IllegalArgumentException("Actor ${actor.node.entityName} is not controllable.")
        return dictionaryOf(
            "actor" to actor.battleId
        )
    }
}