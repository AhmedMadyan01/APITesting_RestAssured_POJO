@Regression @RegressionAPI
Feature: ReqRes get list of users

  @REQRES
  @GETListOfUsers
  Scenario: Validate that Get /api/users Endpoint retrieve the list of users
    Given User invoke the users api successfully
    Then API response status code should be SC_OK
    And API response should contain the expected list of users