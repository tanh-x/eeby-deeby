package battle.entity.character.bnuuy

import battle.entity.character.AbstractCharacterNode
import core.MemberCharacter
import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction

@RegisterClass
class BnuuyNode : AbstractCharacterNode(entityName = MemberCharacter.BNUUY.label) {
    @RegisterFunction
    override fun _ready() {
        super._ready()
        println("BnuuyNode ready")
    }
}