package utils.helpers

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.annotation.RegisterProperty
import godot.signals.Signal0
import godot.signals.Signal1
import godot.signals.Signal2
import godot.signals.Signal3

internal typealias SignalNullary = Signal0
internal typealias SignalUnary<P0> = Signal1<P0>
internal typealias SignalBinary<P0, P1> = Signal2<P0, P1>
internal typealias SignalTernary<P0, P1, P2> = Signal3<P0, P1, P2>
