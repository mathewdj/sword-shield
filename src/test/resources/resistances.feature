Feature: Resist damage
  Scenario Outline: <pokemonType> type resists damage (<damageMultiplier>) to <attackType> attacks
        Given I'm a "<pokemonType>" pokemon
        And attacked with a "<attackType>" move
        Then I should <damageMultiplier> x damage

        Examples: Horizontal
          | pokemonType  | attackType  | damageMultiplier  |
          | normal       | ghost       | 0.0               |
          | fighting     | rock        | 0.5               |
          | fighting     | bug         | 0.5               |
          | fighting     | dark        | 0.5               |
          | flying       | fighting    | 0.5               |
          | flying       | bug         | 0.5               |
          | flying       | grass       | 0.5               |
          | flying       | ground      | 0.0               |
          | poison       | fighting    | 0.5               |
          | poison       | poison      | 0.5               |
          | poison       | grass       | 0.5               |
          | poison       | fairy       | 0.5               |
          | ground       | poison      | 0.5               |
          | ground       | rock        | 0.5               |
          | ground       | electric    | 0.0               |
          | rock         | normal      | 0.5               |
          | rock         | fire        | 0.5               |
          | rock         | poison      | 0.5               |
          | rock         | flying      | 0.5               |
          | bug          | fighting    | 0.5               |
          | bug          | ground      | 0.5               |
          | bug          | grass       | 0.5               |
          | ghost        | poison      | 0.5               |
          | ghost        | bug         | 0.5               |
          | ghost        | normal      | 0.0               |
          | ghost        | fighting    | 0.0               |
          | steel        | normal      | 0.5               |
          | steel        | grass       | 0.5               |
          | steel        | ice         | 0.5               |
          | steel        | flying      | 0.5               |
          | steel        | psychic     | 0.5               |
          | steel        | bug         | 0.5               |
          | steel        | rock        | 0.5               |
          | steel        | dragon      | 0.5               |
          | steel        | steel       | 0.5               |
          | steel        | fairy       | 0.5               |
          | steel        | poison      | 0.0               |
          | fire         | bug         | 0.5               |
          | fire         | grass       | 0.5               |
          | fire         | steel       | 0.5               |
          | fire         | fire        | 0.5               |
          | fire         | ice         | 0.5               |
          | fire         | fairy       | 0.5               |
          | water        | water       | 0.5               |
          | water        | steel       | 0.5               |
          | water        | fire        | 0.5               |
          | water        | ice         | 0.5               |
          | grass        | water       | 0.5               |
          | grass        | grass       | 0.5               |
          | grass        | electric    | 0.5               |
          | grass        | ground      | 0.5               |
          | electric     | electric    | 0.5               |
          | electric     | flying      | 0.5               |
          | electric     | steel       | 0.5               |
          | psychic      | fighting    | 0.5               |
          | psychic      | psychic     | 0.5               |
          | ice          | ice         | 0.5               |
          | dragon       | fire        | 0.5               |
          | dragon       | water       | 0.5               |
          | dragon       | grass       | 0.5               |
          | dragon       | electric    | 0.5               |
          | dark         | ghost       | 0.5               |
          | dark         | dark        | 0.5               |
          | dark         | psychic     | 0.0               |
          | fairy        | fighting    | 0.5               |
          | fairy        | bug         | 0.5               |
          | fairy        | dark        | 0.5               |
          | fairy        | dragon      | 0.0               |
