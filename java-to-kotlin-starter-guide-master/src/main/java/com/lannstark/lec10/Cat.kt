package com.lannstark.lec10

class Cat(
    species: String
): Animal(species, 4) { // super(species, legcount)
    override fun move() {
        println("고양이가 뛰어간다.")
    }

}