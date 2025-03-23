Feature: Login Page Swag Labs

  @SmokeTest @Valid
  Scenario Outline: Check Valid Login
    Given User is on Login Page
    When User enters valid <username> and <password>
    And Clicks on Login Button
    Then User is navigated to Home Page
    And Close the browser

    Examples: 
      | username                  | password       |
      | "standard_user"           | "secret_sauce" |
      | "problem_user"            | "secret_sauce" |
      | "error_user"              | "secret_sauce" |
      | "visual_user"             | "secret_sauce" |

  @SmokeTest @Invalid
  Scenario Outline: Check Invalid Login
    Given User is on Login Page
    When User enters invalid <username> and <password>
    And Clicks on Login Button
    Then User Should see error message
    And Close the browser

    Examples: 
      | username                  | password       |
      | "performance_glitch_user" | "secret_sauc"  |
      | "locked_out_user"         | "secret_sauce" |
