import com.github.javafaker.Faker

data class Sport(val name: String)

fun generateRandomSports(count: Int): List<Sport> {
    val faker = Faker()
    val sportsList = mutableListOf<Sport>()

    repeat(count) {
        val sportName = faker.team().sport()
        sportsList.add(Sport(sportName))
    }

    return sportsList
}
