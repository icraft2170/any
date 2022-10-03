package com.lannstark.lec03

fun main() {
    var str = "Hello"
    println(str[0]) //H
    println(str[1]) //e
    println(str[2]) //l
    println(str[3]) //l
    println(str[str.lastIndex]) //o
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        println(obj.age) // 스마트 캐스트
    }
}
