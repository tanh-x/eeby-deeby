package battle.entity

import godot.Node2D

open class Entity<N : Node2D> : AbstractEntity<N>(), Vulnerable {
	override fun sustainDamage(damage: Double): Double {
		TODO("Not yet implemented")
	}
}