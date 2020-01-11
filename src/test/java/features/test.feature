Feature: Submit Message Feature
  Verify if user is able to Submit a message in to the site

  Scenario: Submit a mesage to the site
    Given user is on homepage
    When user enters Name, Email, Message and clicks Submit
    Then submission success message is displayed