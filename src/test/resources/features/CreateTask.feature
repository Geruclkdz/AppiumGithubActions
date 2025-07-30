Feature: Create New Task
  Scenario Outline: The user create new task
    Given Click Add new task
    And Enter "<TaskName>" and "<TaskDesc>"
    When Click Save
    Then Task added successfully

    Examples:
      | TaskName | TaskDesc |
      | Cucumber Test 1 | Task 1 Details |
      | Cucumber Test 2 | Task 2 Details |