// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.battle.entity.character.wiewior

import battle.entity.character.wiewior.WiewiorNode
import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.battle.entity.character.AbstractCharacterNodeRegistrar
import godot.core.KtConstructor0
import godot.core.VariantType.NIL
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit

public open class WiewiorNodeRegistrar : AbstractCharacterNodeRegistrar() {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<WiewiorNode>("res://scripts/battle/entity/character/wiewior/WiewiorNode.kt", "battle.entity.character.AbstractCharacterNode", WiewiorNode::class, false, "Node2D", "battle_entity_character_wiewior_WiewiorNode") {
        constructor(KtConstructor0(::WiewiorNode))
        function(WiewiorNode::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
