package battle.ai

import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode

/**
 * Data class that stores the complete state of a battle at each turn. Used for purposes
 * of calculating turns for the enemy AI, as well as saving.
 *
 * @param characters List of characters.
 * @param enemies List of enemies
 */
internal data class BattleState(
	internal val characters: HashSet<AbstractCharacter<out AbstractCharacterNode>>,
	internal val enemies: HashSet<AbstractEnemy<out AbstractEnemyNode>>
)