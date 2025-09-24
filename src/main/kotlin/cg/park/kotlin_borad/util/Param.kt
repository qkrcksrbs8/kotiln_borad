package cg.park.kotlin_borad.util

class Param() : HashMap<String, Any>() {

    constructor(key: String, value: Any) : this() {
        put(key, value)
    }

    constructor(vararg pairs: Pair<String, Any>) : this() {
        putAll(pairs)
    }

    constructor(key: String, list: List<Any>) : this() {
        put(key, list)
    }

    fun set(key: String, value: Any) {
        put(key, value)
    }
}