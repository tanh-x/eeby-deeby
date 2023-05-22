package utils.exception

/**
 * This exception is thrown if a property path for a Godot [godot.Node] doesn't exist.
 *
 * @param message The exception message
 */
class NoSuchPropertyException(message: String) : RuntimeException(message)