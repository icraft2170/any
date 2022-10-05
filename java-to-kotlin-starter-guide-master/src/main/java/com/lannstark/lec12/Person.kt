package com.lannstark.lec12


fun main() {
    Singleton.a
}

class Person private constructor(
    var name: String,
    var age: Int,
){
    companion object {
        private const val MIN_AGE = 1;
        fun newBaby(name:String) : Person = Person(name, MIN_AGE)
    }
}

object Singleton{
    var a : Int = 0
}
