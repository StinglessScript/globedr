Feature: Login Functionality

  Background:
    Given I navigate to the login page

  Scenario: Successful Login with valid credentials
    When I login user "0971879660" and pass "067795161"
    Then I should be redirected to the dashboard


  Scenario: Unsuccessful Login with invalid Password
    When I login user "0971879660" and pass "0677951612"
    Then I see toast message "Vui lòng kiểm tra lại số điện thoại, email hoặc mật khẩu của bạn"

  Scenario: Unsuccessful Login with empty credentials
    When I login user "" and pass ""
    Then I see toast message "Vui lòng kiểm tra lại thông tin và thử lại"

  Scenario: Unsuccessful Login with empty password
    When I login user "0971879660" and pass ""
    Then I see toast message "Vui lòng kiểm tra lại thông tin và thử lại"



