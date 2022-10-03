package com.lannstark.lec02

fun main() {
    val person = Person("공부하는 개발자")
    startWithA(person?.name ?: "디폴트 개발자")
}

fun startWithA(str: String) : Boolean {
    return str.startsWith("A")
}



fun startWithB1(str: String?) : Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null 이 들어왔습니다.")
}

fun startWithB2(str: String?): Boolean? {
    return str?.startsWith("A") ?: null
}

fun startWithB3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startWithB4(str: String?): Boolean {
    return str!!.startsWith("A")
}



