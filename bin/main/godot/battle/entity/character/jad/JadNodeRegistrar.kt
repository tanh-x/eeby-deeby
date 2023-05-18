// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.battle.entity.character.jad

import battle.entity.character.jad.JadNode
import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.battle.entity.character.AbstractCharacterNodeRegistrar
import godot.core.KtConstructor0
import godot.core.VariantType.NIL
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit

public open class JadNodeRegistrar : AbstractCharacterNodeRegistrar() {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<JadNode>("res://scripts/battle/entity/character/jad/JadNode.kt", "battle.entity.character.AbstractCharacterNode", JadNode::class, false, "Node2D", "battle_entity_character_jad_JadNode") {
        constructor(KtConstructor0(::JadNode))
        function(JadNode::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
