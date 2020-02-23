package sword

data class Pokemon(val type: PokemonType,
                   val weakTo: List<PokemonType>,
                   val notEffective: List<PokemonType>,
                   val resistDamage: List<PokemonType>,
                   val immunities: List<PokemonType> = emptyList(),
                   val attackImmunities: List<PokemonType> = emptyList(),
                   val superEffective: List<PokemonType> = emptyList())

data class Attack(val type: PokemonType)

