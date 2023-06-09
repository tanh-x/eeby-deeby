package battle.entity.enemy

import godot.core.Vector2
import kotlin.Double.Companion.NaN

@Suppress("SpellCheckingInspection")
internal enum class EnemiesEnum(
	val enemyName: String,
	val health: Double = NaN,
	val power: Double = NaN,
	val shield: Double = NaN,
	val agility: Double = NaN,
) {
	GRAPEMAN(
		enemyName = "Grapeman",
		health = 90.0,
		shield = 15.0,
		power = 10.0,
		agility = 2.0,
	) {
		override fun applyOnInit(ent: AbstractEnemy<out AbstractEnemyNode>) {
			ent as BasicEnemy

			ent.node.sprite.offset = Vector2(-32, -260)
			ent.node.sprite.scale = Vector2.ONE * 1.21
		}
	},

	GREENMAN(
		enemyName = "Greenman",
		health = 70.0,
		shield = 0.0,
		power = 5.0,
		agility = 3.0,
	) {
		override fun applyOnInit(ent: AbstractEnemy<out AbstractEnemyNode>) {
			ent as BasicEnemy

			ent.node.sprite.offset = Vector2(-60, -200)
			ent.node.sprite.scale = Vector2.ONE * 0.76
		}
	}
	;

	internal open fun instantiate(): AbstractEnemy<out AbstractEnemyNode> = instantiateBasicEnemy()
	internal open fun applyOnInit(ent: AbstractEnemy<out AbstractEnemyNode>) {}

	protected fun instantiateBasicEnemy(): BasicEnemy = BasicEnemy(enemyName, health, shield, power, agility)

	companion object {
		@JvmStatic
		val enemies: Array<EnemiesEnum> = EnemiesEnum.values()

		@JvmStatic
		internal operator fun get(id: Int): EnemiesEnum = enemies[id]
	}
}