package utils.exception

/**
 * This exception is thrown if a Godot resource path (res://path/to/resource) does not exist.
 *
 * @param message The exception message
 */
class NoSuchResourceException(message: String) : RuntimeException(message)