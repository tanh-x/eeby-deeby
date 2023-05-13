package battle.entity.enemy

internal enum class EnemiesEnum(
	val enemyName: String,
	val health: Double,
	val damage: Double,
	val shield: Double,
) {
	GRAPEMAN(
		enemyName = "Grapeman",
		health = 50.0,
		damage = 4.0,
		shield = 2.0
	) {
		override fun instantiate(): AbstractEnemy<out AbstractEnemyNode> = instantiateBasicEnemy()
	};

	internal abstract fun instantiate(): AbstractEnemy<out AbstractEnemyNode>

	protected fun instantiateBasicEnemy(): BasicEnemy = BasicEnemy(enemyName, health, shield)


	companion object {
		@JvmStatic
		val enemies: Array<EnemiesEnum> = EnemiesEnum.values()

		@JvmStatic
		internal operator fun get(id: Int): EnemiesEnum = enemies[id]
	}
}