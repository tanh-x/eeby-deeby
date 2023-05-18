// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.graphics

import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.core.KtConstructor0
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.NIL
import godot.registration.ClassRegistrar
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import graphics.SmoothCamera
import kotlin.Unit

public open class SmoothCameraRegistrar : ClassRegistrar {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<SmoothCamera>("res://scripts/graphics/SmoothCamera.kt", "godot.Camera2D", SmoothCamera::class, false, "Camera2D", "graphics_SmoothCamera") {
        constructor(KtConstructor0(::SmoothCamera))
        function(SmoothCamera::_physicsProcess, NIL, DOUBLE to false, KtFunctionArgument(DOUBLE, "kotlin.Double", "delta"), KtFunctionArgument(NIL, "kotlin.Unit"), DISABLED.id.toInt())
      }
    }
  }
}
