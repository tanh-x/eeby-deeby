// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.battle.entity.enemy

import battle.entity.enemy.BasicEnemyNode
import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.core.KtConstructor0
import godot.core.VariantType.NIL
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit

public open class BasicEnemyNodeRegistrar : AbstractEnemyNodeRegistrar() {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<BasicEnemyNode>("res://scripts/battle/entity/enemy/BasicEnemyNode.kt", "battle.entity.enemy.AbstractEnemyNode", BasicEnemyNode::class, false, "Node2D", "battle_entity_enemy_BasicEnemyNode") {
        constructor(KtConstructor0(::BasicEnemyNode))
        function(BasicEnemyNode::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
