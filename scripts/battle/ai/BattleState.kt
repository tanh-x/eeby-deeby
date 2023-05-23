package battle.ai

import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode
import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode

internal data class BattleState(
	internal val characters: HashSet<AbstractCharacter<out AbstractCharacterNode>>,
	internal val enemies: HashSet<AbstractEnemy<out AbstractEnemyNode>>
)