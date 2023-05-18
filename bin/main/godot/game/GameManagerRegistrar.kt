// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.game

import game.GameManager
import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.core.KtConstructor0
import godot.core.VariantType.NIL
import godot.core.VariantType.STRING
import godot.registration.ClassRegistrar
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit

public open class GameManagerRegistrar : ClassRegistrar {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<GameManager>("res://scripts/game/GameManager.kt", "godot.Node", GameManager::class, false, "Node", "game_GameManager") {
        constructor(KtConstructor0(::GameManager))
        function(GameManager::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
        function(GameManager::initializeBattleScene, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
        function(GameManager::switchSceneSafely, NIL, STRING to false, KtFunctionArgument(STRING, "kotlin.String", "path"), KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
        function(GameManager::switchScene, NIL, STRING to false, KtFunctionArgument(STRING, "kotlin.String", "path"), KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
