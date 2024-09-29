package globedr.steps;

import globedr.pages.DashboardPage;
import globedr.pages.LoginPage;
import globedr.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
  LoginPage loginPage = new LoginPage();

  @Given("I navigate to the login page")
  public void iNavigateToTheLoginPage() {
    DriverManager.navigateTo("https://globedr.com/signin");
  }

  @When("I login user {string} and pass {string}")
  public void iLoginUserAndPass(String username, String password) {
    loginPage.login(username, password);
  }

  @Then("I see toast message {string}")
  public void iSeeToastMessage(String expectedMessage) {
   try {
      String actualMessage = loginPage.getToastMessage();
      assertEquals(expectedMessage, actualMessage);
    } catch (AssertionError e) {
      DriverManager.takeScreenshot("login_toast_not_match.png");
      throw e;
   }
  }
}


