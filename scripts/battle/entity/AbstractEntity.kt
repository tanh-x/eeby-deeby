package battle.entity

import godot.Node2D

abstract class AbstractEntity<N : Node2D>(
    internal val node: N,
    internal val playerSide: Boolean
)