package battle

import battle.entity.enemy.AbstractEnemy
import battle.entity.enemy.AbstractEnemyNode
import battle.entity.character.AbstractCharacter
import battle.entity.character.AbstractCharacterNode

/**
 * Internally computes and manages everything related to the battle. Including stats calculations,
 * move validations, and makes inquiry calls to a delegated external class that handles the enemy AI.
 * This class is self-encapsulated and *mostly* decoupled from the rest of the game.
 *
 * @see BattleScene
 */
internal class BattleManager(
    internal val scene: BattleScene,
    internal val characters: LinkedHashMap<Int, AbstractCharacter<out AbstractCharacterNode>>,
    internal val enemies: LinkedHashMap<Int, AbstractEnemy<out AbstractEnemyNode>>,
) {

}