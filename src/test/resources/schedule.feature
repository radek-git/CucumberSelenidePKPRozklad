Feature: Schedule
  Scenario Outline: User should find results
    Given User opens page
    When User inputs station form <station_from>
    And User inputs station to <station_to>
    And User selects day of current month <day>
    And User selects time <time>
    And User selects travel options <travel_options>
    When User clicks search button
    Then Results are displayed
    Examples:
      | station_from | station_to      | day  | time    | travel_options            |
      | "WARSZAWA-"  | "GDAŃSK GŁÓWNY" | "28" | "10:00" | "Połączenia bezpośrednie" |