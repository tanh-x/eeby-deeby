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
		health = 50.0,
		shield = 2.0,
		power = 8.0,
		agility = 2.0,
	) {
		override fun applyOnInit(ent: AbstractEnemy<out AbstractEnemyNode>) {
			ent as BasicEnemy

			ent.node.sprite.offset = Vector2(-32, -260)
			ent.node.sprite.scale = Vector2(1.3, 1.3)
		}
	},

	GREENMAN(
		enemyName = "Greenman",
		health = 34.0,
		shield = 0.0,
		power = 6.0,
		agility = 3.0,
	) {
		override fun applyOnInit(ent: AbstractEnemy<out AbstractEnemyNode>) {
			ent as BasicEnemy

			ent.node.sprite.offset = Vector2(-60, -200)
			ent.node.sprite.scale = Vector2(0.85, 0.85)
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