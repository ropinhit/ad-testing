@a
Feature: Testing header and footer of deerberg

  Scenario Outline: Verify the header displayed correctly
    When I go to the '<url>' page
    And I click all link from menu
#      Then I should see Katalog icon
#      And I should see Mein Konto
#      And I should see Newsletter
#      And I should see Warenkorb
#
    Examples:
      | url                     |
#      | https://www.deerberg.ch |
#      | https://www.deerberg.de |
      | https://www.deerberg.at |

#  Scenario: debug
#    When I open the link and next link 'https://www.deerberg.de/de/marken/el-naturalista'
#
#  Scenario: test
#    When I check number of page 'https://test.deerberg.de'