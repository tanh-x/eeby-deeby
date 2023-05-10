package battle.entity.enemy

internal enum class EnemiesEnum(
	val maxHealth: Double,
	val baseDamage: Double,
	val baseDefense: Double,
) {
	GRAPEMAN(
		maxHealth = 50.0,
		baseDamage = 4.0,
		baseDefense = 6.0
	) {
		override fun instantiate(): AbstractEnemy<out AbstractEnemyNode> {
			TODO("Not yet implemented")
		}
	};

	internal abstract fun instantiate(): AbstractEnemy<out AbstractEnemyNode>


	companion object {
		@JvmStatic
		val enemies: Array<EnemiesEnum> = EnemiesEnum.values()

		@JvmStatic
		internal operator fun get(id: Int): EnemiesEnum = enemies[id]
	}
}