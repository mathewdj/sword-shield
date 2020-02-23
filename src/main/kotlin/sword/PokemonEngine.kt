package sword

import sword.PokemonType.*

object PokemonEngine {
    private val typeMap = listOf(
            Pokemon(Normal,
                    weakTo = listOf(Fighting),
                    resistDamage = listOf(),
                    notEffective = listOf(Rock, Steel),
                    immunities = listOf(Ghost),
                    attackImmunities = listOf(Ghost)),
            Pokemon(Dark, weakTo = listOf(Fighting, Bug, Fairy),
                    resistDamage = listOf(Ghost, Dark),
                    immunities = listOf(Psychic),
                    notEffective = listOf(Fighting, Dark, Fairy)),
            Pokemon(Fairy,
                    weakTo = listOf(Poison, Steel),
                    resistDamage = listOf(Bug, Dark, Fighting),
                    immunities = listOf(Dragon),
                    notEffective = listOf(Poison, Steel, Fire)),
            Pokemon(Fighting,
                    weakTo = listOf(Flying, Fairy, Psychic),
                    resistDamage = listOf(Rock, Bug, Dark),
                    notEffective = listOf(Flying, Bug, Psychic),
                    attackImmunities = listOf(Ghost),
                    superEffective = listOf(Normal, Ice, Rock, Dark, Steel)),
            Pokemon(Poison,
                    weakTo = listOf(Ground, Psychic),
                    resistDamage = listOf(Fighting, Poison, Grass, Fairy),
                    notEffective = listOf(Poison, Ground, Rock),
                    attackImmunities = listOf(Steel)),
            Pokemon(Ground,
                    weakTo = listOf(Water, Grass, Ice),
                    resistDamage = listOf(Poison, Rock),
                    immunities = listOf(Electric),
                    notEffective = listOf(Bug, Grass),
                    attackImmunities = listOf(Flying)),
            Pokemon(Rock,
                    weakTo = listOf(Water, Grass, Ground, Steel, Fighting),
                    resistDamage = listOf(Normal, Fire, Poison, Flying),
                    notEffective = listOf(Fighting, Ground, Steel)),
            Pokemon(Bug,
                    weakTo = listOf(Rock, Flying, Fire),
                    resistDamage = listOf(Fighting, Ground, Grass),
                    notEffective = listOf(Poison, Fighting, Flying, Ghost, Steel, Fire, Fairy)),
            Pokemon(Ghost, weakTo = listOf(Ghost, Dark),
                    resistDamage = listOf(Poison, Bug),
                    immunities = listOf(Normal, Fighting),
                    notEffective = listOf(Dark),
                    attackImmunities = listOf(Normal)),
            Pokemon(Steel, weakTo = listOf(Fire, Fighting, Ground),
                    resistDamage = listOf(Normal, Grass, Ice, Flying, Psychic, Bug, Rock, Dragon, Steel, Fairy),
                    immunities = listOf(Poison),
                    notEffective = listOf(Fire, Water, Steel, Electric)),
            Pokemon(Water,
                    weakTo = listOf(Grass, Electric),
                    resistDamage = listOf(Fire, Ice, Water, Steel),
                    notEffective = listOf(Dragon, Grass, Water)),
            Pokemon(Fire,
                    weakTo = listOf(Rock, Ground, Water),
                    resistDamage = listOf(Bug, Steel, Fire, Grass, Ice, Fairy),
                    notEffective = listOf(Rock, Fire, Water, Dragon)),
            Pokemon(Grass,
                    weakTo = listOf(Fire, Poison, Bug, Flying),
                    resistDamage = listOf(Water, Grass, Electric, Ground),
                    notEffective = listOf(Flying, Poison, Bug, Steel, Fire, Grass, Dragon)),
            Pokemon(Electric,
                    weakTo = listOf(Ground),
                    resistDamage = listOf(Flying, Steel, Electric),
                    notEffective = listOf(Grass, Dragon, Electric),
                    attackImmunities = listOf(Ground)),
            Pokemon(Psychic,
                    weakTo = listOf(Dark, Bug, Ghost),
                    resistDamage = listOf(Ground, Fighting, Psychic),
                    notEffective = listOf(Steel, Psychic),
                    attackImmunities = listOf(Dark)),
            Pokemon(Ice,
                    weakTo = listOf(Fighting, Fire, Rock, Steel),
                    resistDamage = listOf(Ice),
                    notEffective = listOf(Steel, Fire, Water, Ice)),
            Pokemon(Dragon,
                    weakTo = listOf(Fairy, Dragon, Ice),
                    resistDamage = listOf(Fire, Water, Grass, Electric),
                    notEffective = listOf(Steel)),
            Pokemon(Flying,
                    weakTo = listOf(Electric, Rock, Ice),
                    resistDamage = listOf(Fighting, Bug, Grass),
                    immunities = listOf(Ground),
                    notEffective = listOf(Electric, Rock, Steel)
            )
    ).associateBy { it.type.name.toLowerCase() }

    private val attackTypes = enumValues<PokemonType>().associateBy { it.name.toLowerCase() }

    fun calcDefenseMultiplier(pokemon: Pokemon, attack: Attack): Double {
        return when (attack.type) {
            in pokemon.weakTo -> 2.0
            in pokemon.immunities -> 0.0
            in pokemon.resistDamage -> 0.5
            else -> 1.0
        }
    }

    fun calcAttackMultiplier(attack: Attack, pokemon: Pokemon): Double {
        return when (attack.type) {
            in pokemon.notEffective -> 0.5
            in pokemon.attackImmunities -> 0.0
            in pokemon.superEffective -> 2.0
            else -> 1.0
        }
    }

    fun determineType(type: String): Pokemon = typeMap[type] ?: error("Missing type: $type")

    fun determineAttackType(type: String): Attack =
            Attack(attackTypes[type.toLowerCase()] ?: error("Missing attack type: $type"))
}