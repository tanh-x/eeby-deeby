package battle.core

enum class ActionType {
    SELF,  // An action that is targeted towards the actor
    OFFENSE,  // An action that is targeted towards their opponent
    SUPPORT,  // An action that is targeted towards their ally
    SPECIAL,  // A special action, optional.
}

