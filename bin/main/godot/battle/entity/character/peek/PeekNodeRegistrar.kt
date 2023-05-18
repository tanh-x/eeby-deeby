// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.battle.entity.character.peek

import battle.entity.character.peek.PeekNode
import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.battle.entity.character.AbstractCharacterNodeRegistrar
import godot.core.KtConstructor0
import godot.core.VariantType.NIL
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit

public open class PeekNodeRegistrar : AbstractCharacterNodeRegistrar() {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<PeekNode>("res://scripts/battle/entity/character/peek/PeekNode.kt", "battle.entity.character.AbstractCharacterNode", PeekNode::class, false, "Node2D", "battle_entity_character_peek_PeekNode") {
        constructor(KtConstructor0(::PeekNode))
        function(PeekNode::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
