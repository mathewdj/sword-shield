Feature: Super effective vs

  Scenario Outline: <attackTypesList> super effective against (<damageMultiplier>) <pokemonType>
    Given I attack with any attacks in <attackTypesList>
    When my attack reaches with a "<pokemonType>" type
    Then all attacks have attack modifier of <damageMultiplier> x

    Examples: Horizontal
      | pokemonType  | damageMultiplier  | attackTypesList                           |
      | fighting     | 2.0               | Normal, Ice, Rock, Dark, Steel            |




