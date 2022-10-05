package com.lannstark.lec10

class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable{
    private val wingCount : Int = 2

    override fun move() {
        print("펭귄이 헤엄친다.")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Flyable>.act()
        super<Swimable>.act()
    }
}