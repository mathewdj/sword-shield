Feature: Weak vs

  Scenario Outline: <pokemonType> type is weak vs <attackType> attacks
    Given I'm a "<pokemonType>" pokemon
    And attacked with a "<attackType>" move
    Then I should <damageMultiplier> x damage
    And all other damage types should be <normalDamageMultiplier> that I am not resistant to

    Examples: Horizontal
      | pokemonType  | attackType  | damageMultiplier  | normalDamageMultiplier |
      | normal       | fighting    | 2.0               | 1.0                    |
      | water        | grass       | 2.0               | 1.0                    |
      | water        | electric    | 2.0               | 1.0                    |
      | fairy        | poison      | 2.0               | 1.0                    |
      | fairy        | steel       | 2.0               | 1.0                    |
      | dark         | fighting    | 2.0               | 1.0                    |
      | dark         | bug         | 2.0               | 1.0                    |
      | dark         | fairy       | 2.0               | 1.0                    |
      | fighting     | flying      | 2.0               | 1.0                    |
      | fighting     | psychic     | 2.0               | 1.0                    |
      | fighting     | fairy       | 2.0               | 1.0                    |
      | flying       | electric    | 2.0               | 1.0                    |
      | flying       | rock        | 2.0               | 1.0                    |
      | flying       | ice         | 2.0               | 1.0                    |
      | poison       | ground      | 2.0               | 1.0                    |
      | poison       | psychic     | 2.0               | 1.0                    |
      | ground       | water       | 2.0               | 1.0                    |
      | ground       | grass       | 2.0               | 1.0                    |
      | ground       | ice         | 2.0               | 1.0                    |
      | rock         | water       | 2.0               | 1.0                    |
      | rock         | grass       | 2.0               | 1.0                    |
      | rock         | ground      | 2.0               | 1.0                    |
      | rock         | steel       | 2.0               | 1.0                    |
      | rock         | fighting    | 2.0               | 1.0                    |
      | bug          | flying      | 2.0               | 1.0                    |
      | bug          | rock        | 2.0               | 1.0                    |
      | bug          | fire        | 2.0               | 1.0                    |
      | ghost        | dark        | 2.0               | 1.0                    |
      | ghost        | ghost       | 2.0               | 1.0                    |
      | steel        | fire        | 2.0               | 1.0                    |
      | steel        | fighting    | 2.0               | 1.0                    |
      | steel        | ground      | 2.0               | 1.0                    |
      | fire         | ground      | 2.0               | 1.0                    |
      | fire         | rock        | 2.0               | 1.0                    |
      | fire         | water       | 2.0               | 1.0                    |
      | grass        | flying      | 2.0               | 1.0                    |
      | grass        | poison      | 2.0               | 1.0                    |
      | grass        | bug         | 2.0               | 1.0                    |
      | grass        | fire        | 2.0               | 1.0                    |
      | electric     | ground      | 2.0               | 1.0                    |
      | psychic      | bug         | 2.0               | 1.0                    |
      | psychic      | ghost       | 2.0               | 1.0                    |
      | psychic      | dark        | 2.0               | 1.0                    |
      | ice          | fighting    | 2.0               | 1.0                    |
      | ice          | rock        | 2.0               | 1.0                    |
      | ice          | steel       | 2.0               | 1.0                    |
      | ice          | fire        | 2.0               | 1.0                    |
      | dragon       | ice         | 2.0               | 1.0                    |
      | dragon       | fairy       | 2.0               | 1.0                    |
      | dragon       | dragon      | 2.0               | 1.0                    |
      | dark         | fighting    | 2.0               | 1.0                    |
      | dark         | bug         | 2.0               | 1.0                    |
      | dark         | fairy       | 2.0               | 1.0                    |
      | fairy        | poison      | 2.0               | 1.0                    |
      | fairy        | steel       | 2.0               | 1.0                    |

