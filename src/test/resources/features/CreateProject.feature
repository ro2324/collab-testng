Feature: Create New Project on Garage Dashboard

  Background:
    Given I am logged in to the Garage Dashboard

  Scenario: Successfully create a new project using the two-step form process
    When I click on the "Create New Project" button
    Then I should see Form 1 for basic project information

    When I fill in the required fields in Form 1:
      | Field           | Value                     |
      | Project Name    | Test Automation Framework |
      | Description     | A comprehensive test automation framework |
      | Project Keywords| automation, testing, framework |
      | Events          | Hackathon 2023            |
      | Project End Date| 2023-12-31                |
    And I upload a project cover image
    And I click the "Next" button
    Then I should see Form 2 for additional project details

    When I fill in the optional fields in Form 2:
      | Field                | Value                     |
      | Project Info         | Additional project details|
      | Environments         | Dev, QA, Staging          |
      | Promotional Artifacts| Project presentation      |
      | Video                | https://example.com/video |
      | Contacts             | john.doe@example.com      |
    And I click the "Create Project" button
    Then I should be redirected to the Dashboard
    And I should see the new project "Test Automation Framework" on the Dashboard

  Scenario: Navigate back from Form 2 to Form 1
    Given I have completed Form 1 and am on Form 2
    When I click the "Back" button
    Then I should be taken back to Form 1
    And my previously entered information should be preserved

  Scenario Outline: Validate required fields in Form 1
    When I click on the "Create New Project" button
    And I leave the "<Field>" field empty
    And I try to proceed to Form 2
    Then I should see an error message for the "<Field>" field

    Examples:
      | Field           |
      | Project Name    |
      | Description     |
      | Project Keywords|
      | Events          |
      | Project End Date|

  Scenario: Attempt to create project without uploading cover image
    When I click on the "Create New Project" button
    And I fill in all required fields in Form 1 except the project cover
    And I try to proceed to Form 2
    Then I should see an error message about the missing project cover

  Scenario: Create project with minimum required information
    When I click on the "Create New Project" button
    And I fill in only the required fields in Form 1:
      | Field           | Value            |
      | Project Name    | Minimal Project  |
      | Description     | A minimal project|
      | Project Keywords| minimal          |
      | Events          | Meetup 2023      |
      | Project End Date| 2023-10-31       |
    And I upload a project cover image
    And I click the "Next" button
    And I click the "Create Project" button without filling Form 2
    Then I should be redirected to the Dashboard
    And I should see the new project "Minimal Project" on the Dashboard

  Scenario: Attempt to create a project with a past end date
    When I click on the "Create New Project" button
    And I fill in all required fields in Form 1
    But I set the Project End Date to a past date
    And I try to proceed to Form 2
    Then I should see an error message about invalid project end date