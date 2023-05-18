// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY! ALL CHANGES TO IT WILL BE OVERWRITTEN ON EACH BUILD
package godot.battle.entity

import godot.registration.ClassRegistrar
import godot.registration.ClassRegistry
import kotlin.Unit

/**
 * Registrar for abstract class. Does not register any members as it's only used for default value
 * providing if any properties with default values are provided in the abstract class. Members of this
 * abstract class are registered by the inheriting registrars
 */
public open class AbstractEntityNodeRegistrar : ClassRegistrar {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      // Abstract classes don't need to have any members to be registered
    }
  }
}
