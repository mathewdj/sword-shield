package sword

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import sword.PokemonEngine.determineAttackType
import sword.PokemonEngine.determineType
import sword.PokemonEngine.calcAttackMultiplier
import sword.PokemonEngine.calcDefenseMultiplier
import kotlin.test.assertEquals

class StepDefs {
    lateinit var pokemon: Pokemon
    lateinit var attack: Attack
    lateinit var attackTypesList: List<Attack>

    @Given("I'm a {string} pokemon")
    fun pokemon(type: String) {
        pokemon = determineType(type)
    }

    @Given("attacked with a {string} move")
    fun attack(attackType: String) {
        attack = determineAttackType(attackType)
    }

    @Then("I should {double} x damage")
    fun assertDamageMultiplier(damageMultiplier: Double) {
        assertEquals(damageMultiplier, calcDefenseMultiplier(pokemon, attack))
    }

    @Then("I should have attack modifier of {double} x")
    fun assertAttackDamageMultiplier(damageMultiplier: Double) {
        assertEquals(damageMultiplier, calcAttackMultiplier(attack, pokemon))
    }

    @Then("all attacks have attack modifier of {double} x")
    fun assertAttackDamageMultiplier2(damageMultiplier: Double) {
        attackTypesList.forEach {  assertEquals(damageMultiplier, calcAttackMultiplier(it, pokemon)) }
    }

    @Then("all other damage types should be {double} that I am not resistant to")
    fun assertNormalDamageMultiplier(normalDamageMuliplier: Double) {
        val normalAttackMultiplierAttacks = enumValues<PokemonType>()
                .filterNot { it in pokemon.weakTo }
                .filterNot { it in pokemon.notEffective }
                .filterNot { it in pokemon.resistDamage }
                .filterNot { it in pokemon.immunities }
                .map { Attack(it) }

        assertEquals(setOf(1.0), normalAttackMultiplierAttacks.map { calcDefenseMultiplier(pokemon, it) }.toSet())
    }

    @Given("I attack with {string}")
    fun iAttackWith(attackType: String) {
        attack = determineAttackType(attackType)
    }

    @When("my attack reaches with a {string} type")
    fun attackReachesPokemon(pokemonType: String) {
        pokemon = determineType(pokemonType)
    }

    @Given("^I attack with any attacks in $")
    fun listOfAttacks(attackTypes: String) {
        println(attackTypes)
        attackTypesList = attackTypes.split(", ").map { determineAttackType(it) }
    }
}