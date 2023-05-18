// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.battle.entity.character.kew

import battle.entity.character.kew.KewNode
import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.battle.entity.character.AbstractCharacterNodeRegistrar
import godot.core.KtConstructor0
import godot.core.VariantType.NIL
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit

public open class KewNodeRegistrar : AbstractCharacterNodeRegistrar() {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<KewNode>("res://scripts/battle/entity/character/kew/KewNode.kt", "battle.entity.character.AbstractCharacterNode", KewNode::class, false, "Node2D", "battle_entity_character_kew_KewNode") {
        constructor(KtConstructor0(::KewNode))
        function(KewNode::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
