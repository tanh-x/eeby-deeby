package battle.entity.enemy

import battle.entity.AbstractEntity

abstract class AbstractEnemy<N : AbstractEnemyNode>
internal constructor(node: N) : AbstractEntity<N>(node)