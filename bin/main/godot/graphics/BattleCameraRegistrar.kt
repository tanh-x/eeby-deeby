// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.graphics

import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.core.KtConstructor0
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.NIL
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import graphics.BattleCamera
import kotlin.Unit

public open class BattleCameraRegistrar : SmoothCameraRegistrar() {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<BattleCamera>("res://scripts/graphics/BattleCamera.kt", "graphics.SmoothCamera", BattleCamera::class, false, "Camera2D", "graphics_BattleCamera") {
        constructor(KtConstructor0(::BattleCamera))
        function(BattleCamera::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
        function(BattleCamera::_physicsProcess, NIL, DOUBLE to false, KtFunctionArgument(DOUBLE, "kotlin.Double", "delta"), KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
