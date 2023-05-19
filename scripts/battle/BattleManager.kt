package battle

import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import character.AbstractCharacter
import character.AbstractCharacterNode

/**
 * Internally computes and manages everything related to the battle. Including stats calculations,
 * move validations, and makes inquiry calls to a delegated external class that handles the enemy AI.
 * This class is self-encapsulated and *mostly* decoupled from the rest of the game.
 *
 * @see BattleScene
 */
internal class BattleManager(
    internal val scene: BattleScene,
    internal val characters: LinkedHashSet<AbstractCharacter<out AbstractCharacterNode>>,
    internal val enemies: LinkedHashSet<AbstractEnemy<out AbstractEnemyNode>>
) {

}