package character.ober

import character.AbstractCharacterNode
import character.MemberCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class OberNode: AbstractCharacterNode(entityName = MemberCharacter.OBER.label) {
    @RegisterFunction
    override fun _ready() {
        super._ready()
        println("OberNode ready")
    }
}