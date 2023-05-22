package battle.entity

import kotlin.properties.Delegates

abstract class AbstractEntity<N : AbstractEntityNode>(
	internal val node: N,
	internal val playerSide: Boolean,
) {
	internal var battleId: Int by Delegates.notNull()

	override fun toString(): String = "(${if (playerSide) '+' else '-'}${node.entityName})"
}