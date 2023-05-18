// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.battle.entity.character.dogman

import battle.entity.character.dogman.DogmanNode
import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.battle.entity.character.AbstractCharacterNodeRegistrar
import godot.core.KtConstructor0
import godot.core.VariantType.NIL
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit

public open class DogmanNodeRegistrar : AbstractCharacterNodeRegistrar() {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<DogmanNode>("res://scripts/battle/entity/character/dogman/DogmanNode.kt", "battle.entity.character.AbstractCharacterNode", DogmanNode::class, false, "Node2D", "battle_entity_character_dogman_DogmanNode") {
        constructor(KtConstructor0(::DogmanNode))
        function(DogmanNode::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
