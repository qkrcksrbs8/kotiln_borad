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

    fun success() : Param {
        put("status", "200")
        put("code", "S0001")
        put("message", "Success")
        return this
    }
    fun success(value: Any) : Param {
        put("status", "200")
        put("code", "S0001")
        put("message", "Success")
        put("data", value)
        return this
    }

    fun fail() : Param {
        put("status", "400")
        put("code", "F0001")
        put("message", "Fail")
        return this
    }

    fun fail(value: Any) : Param {
        put("status", "400")
        put("code", "F0001")
        put("message", "Fail")
        put("data", value)
        return this
    }

}
