Feature: Toolbar Tests Scenarios

  Background:
    Given I opened the app successfully

#  Scenario: Validate the Action Icons count on the toolbar
#    Then I should see 4 action icons on the toolbar
#
#  Scenario: Validate Default View on the page
#    Then app name should be "Plaid"
#    And the page theme should become "light theme"
#
#  Scenario: Theme Switch Validation
#    When I click toolbar icon "Theme"
#    Then the page theme should become "dark theme"
#    And  I wait for a while
#    When I click toolbar icon "Theme"
#    Then the page theme should become "light theme"
#
#  Scenario Outline: Action icons Functionality Validation
#    Then Toolbar icon "<toolbarIcon>" should be working properly
#    Examples:
#      | toolbarIcon    |
#      | Search         |
#      | Theme          |
#      | Filter         |
#      | MoreOptions    |
#
#  Scenario: Filter Toolbar Icon - Default Selected Filters Validation
#    When I click toolbar icon "Filter"
#    Then I should see "Popular Designer News" as selected
#    And  I should see "Material Design" as selected
#
#  Scenario Outline: Filter results Validation
#    Given I unselected all the selected filters
#    And  I selects "<filter>"
#    Then I should see results on the home screen
#    Examples:
#      | filter                |
#      | Popular Designer News |
#      | Material Design       |
#      | Product Hunt          |
#
#  Scenario: Filter results Validation - No filters selected
#    When I unselected all the selected filters
#    Then I should see no filter selected warning

  Scenario Outline: More Options Icon check - Navigation to Login to Designer News
    Given I click toolbar icon "MoreOptions"
    When  I click option "<optionTag>"
    Then The application should navigate to proper page
    Examples:
      | optionTag              |
      | Login to Designer News |
      | About                  |


