package com.lannstark.lec09


fun main() {
    val person = Person("Hero", 10)
    println(person.name)
    person.age = 25
    println(person.age)
}

class Person (
    name: String,
    var age : Int,
        ){
    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 ${age} 일 수 없습니다.")
        }
    }

    var name = name
        get() = field.uppercase()
        set(value) {
            field = value.uppercase()
        }





    val isAdult: Boolean
        get() {
            return this.age >= 20
        }

}