package battle.entity.character

import battle.entity.AbstractEntity
import battle.entity.Vulnerable


abstract class AbstractCharacter<N: AbstractCharacterNode>: AbstractEntity<N>(), Vulnerable {

}