Feature: Update Profile Functionality

  Background:
    Given I navigate to the login page
    When I login user "0971879660" and pass "06779516"
    Then I should be redirected to the dashboard
    And I navigate to the profile page

  Scenario Outline: Update Personal Information with different sets of valid information
    When I update the profile with the following personal information:
      | fullName   | email   | title   | phoneNumber   | workPhone   | unit   | gender   | dateOfBirth   |
      | <fullName> | <email> | <title> | <phoneNumber> | <workPhone> | <unit> | <gender> | <dateOfBirth> |
    Then I should see the profile updated successfully

    Examples:
      | fullName | email               | title | phoneNumber | workPhone  | unit            | gender | dateOfBirth |
      | Công Võ  | cong.vo@example.com | Mr.   | 1234567890  | 0987654321 | VN (kg/m)       | Nam    | 01011990    |
      | Xàm      | xam@example.com     | Mr.   | 9876543210  | 1234567890 | US (pound/feet) | Nữ     | 05061985    |

  Scenario Outline: Update Personal Information with different sets of invalid information
    When I update the profile with the following personal information:
      | fullName   | email   | title   | phoneNumber   | workPhone   | unit   | gender   | dateOfBirth   |
      | <fullName> | <email> | <title> | <phoneNumber> | <workPhone> | <unit> | <gender> | <dateOfBirth> |
    Then I should see the profile updated failed

    Examples:
      | fullName | email  | title | phoneNumber | workPhone  | unit      | gender | dateOfBirth |
      | Công Võ  | cong.v | Mr.   | 1234567890  | 0987654321 | VN (kg/m) | Nam    | 01011990    |


  Scenario Outline: Update Address Information with different sets of valid information
    When I update the profile with the following address information:
      | country   | currentCountry   | city   | district   | ward   | address   |
      | <country> | <currentCountry> | <city> | <district> | <ward> | <address> |
    Then I should see the profile updated successfully

    Examples:
      | country | currentCountry | city  | district  | ward  | address          |
      | Vietnam | Vietnam        | City1 | District1 | Ward1 | 123 Main St      |
      | Vietnam | Vietnam        | City2 | District2 | Ward2 | 456 Another St   |
      | Vietnam | Vietnam        | City3 | District3 | Ward3 | 789 Different St |

