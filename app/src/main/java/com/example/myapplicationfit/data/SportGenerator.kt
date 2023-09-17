package com.example.myapplicationfit.data

fun generateHardCodedSports(): List<Sport> {

    return listOf(
        Sport(1, "Soccer"),
        Sport(2, "Basketball"),
        Sport(3, "Tennis"),
        Sport(4, "Baseball"),
        Sport(5, "Golf"),
        Sport(6, "Swimming"),
        Sport(7, "Cycling"),
        Sport(8, "Running"),
        Sport(9, "Volleyball"),
        Sport(10, "Hockey")
    )
}

fun getSportById(sportId: Int): Sport? {
    val sportsList = generateHardCodedSports()
    return sportsList.find { it.id == sportId }
}