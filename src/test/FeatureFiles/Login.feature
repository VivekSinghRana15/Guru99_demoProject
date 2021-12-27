Feature: This feature file is to login to Guru99 Banking Demo website

  @Vivek
  Scenario Outline: Sr-"<Number>" This scenario is to test login to Guru99 Bank website
    Given I open the Guru99 Banking website "<URL>"
    When I enter "<Username>" and "<Password>"
    And I click on Login button
    Then I should successfully login and reach Home Page of Banking website
    And I Logout and Close Browser
    Examples:
      | Number | URL                                 | Username  | Password  |
      | 101     | http://demo.guru99.com/V1/index.php | mngr26593 | 123456aA! |


