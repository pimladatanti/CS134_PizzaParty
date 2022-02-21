package com.zybooks.pizzaparty

import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

// Calculates number of pizza needed for certain party size
class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
    var partySize = 0
        // Set partySize only if size given >= 0. If <0, set to 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    // Different number of slices per person depending on hunger level
    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }
    // Returns total number of pizzas needed for party size based on hunger
    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}