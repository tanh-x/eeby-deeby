package utils.helpers

/**
 * Checks if there is a duplicated element in the [Collection]
 */
fun <E> Collection<E>.duplicated(): Boolean {
	val set: HashSet<E> = HashSet()
	this.forEach { if (!set.add(it)) return true }
	return false
}

/**
 * Checks if there is a duplicated element in the [Array]
 */
fun <E> Array<E>.duplicated(): Boolean {
	val set: HashSet<E> = HashSet()
	this.forEach { if (!set.add(it)) return true }
	return false
}