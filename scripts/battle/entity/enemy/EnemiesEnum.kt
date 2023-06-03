package battle.entity.enemy

import godot.core.Vector2
import kotlin.Double.Companion.NaN

@Suppress("SpellCheckingInspection")
internal enum class EnemiesEnum(
	val enemyName: String,
	val health: Double = NaN,
	val damage: Double = NaN,
	val shield: Double = NaN,
	val power: Double = NaN,
	val agility: Double = NaN,
) {
	GRAPEMAN(
		enemyName = "Grapeman",
		health = 50.0,
		damage = 4.0,
		shield = 2.0,
		power = 16.0,
		agility = 2.0,
	) {
		override fun instantiate(): AbstractEnemy<out AbstractEnemyNode> = instantiateBasicEnemy()
		override fun applyOnInit(ent: AbstractEnemy<out AbstractEnemyNode>) {
			ent as BasicEnemy

			// Grapeman texture needs to be offset by this amount
			ent.node.sprite.offset = Vector2(-32, -260)
			ent.node.sprite.scale = Vector2(1.3, 1.3)
		}
	};

	internal abstract fun instantiate(): AbstractEnemy<out AbstractEnemyNode>
	internal open fun applyOnInit(ent: AbstractEnemy<out AbstractEnemyNode>) {}

	protected fun instantiateBasicEnemy(): BasicEnemy = BasicEnemy(enemyName, health, shield, power, agility)

	companion object {
		@JvmStatic
		val enemies: Array<EnemiesEnum> = EnemiesEnum.values()

		@JvmStatic
		internal operator fun get(id: Int): EnemiesEnum = enemies[id]
	}
}