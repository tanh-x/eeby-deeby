// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.ui.battle

import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.core.KtConstructor0
import godot.core.VariantType.NIL
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit
import ui.battle.PlayerOverlay

public open class PlayerOverlayRegistrar : EntityOverlayRegistrar() {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<PlayerOverlay>("res://scripts/ui/battle/PlayerOverlay.kt", "ui.battle.EntityOverlay", PlayerOverlay::class, false, "Control", "ui_battle_PlayerOverlay") {
        constructor(KtConstructor0(::PlayerOverlay))
        function(PlayerOverlay::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
        function(PlayerOverlay::updateAll, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
