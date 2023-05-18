// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.utils.helpers

import godot.MultiplayerAPI.RPCMode.DISABLED
import godot.core.KtConstructor0
import godot.core.VariantType.STRING
import godot.registration.ClassRegistrar
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit
import utils.helpers.JvmFacade

public open class JvmFacadeRegistrar : ClassRegistrar {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<JvmFacade>("res://scripts/utils/helpers/JvmFacade.kt", "godot.Node", JvmFacade::class, false, "Node", "utils_helpers_JvmFacade") {
        constructor(KtConstructor0(::JvmFacade))
        function(JvmFacade::memory, STRING, KtFunctionArgument(STRING, "kotlin.String"), DISABLED.id.toInt())
      }
    }
  }
}
