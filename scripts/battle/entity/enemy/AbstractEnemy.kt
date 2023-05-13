package battle.entity.enemy

import battle.entity.AbstractEntity

abstract class AbstractEnemy<N : AbstractEnemyNode>(node: N) : AbstractEntity<N>(node)