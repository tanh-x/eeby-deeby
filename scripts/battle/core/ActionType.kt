package battle.core

enum class ActionType {
	OFFENSE,  // An action that is targeted towards their opponent
	SUPPORT,  // An action that is targeted towards their ally
	SELF,  // An action that is targeted towards the actor
	SPECIAL,  // A special action, optional.
}

