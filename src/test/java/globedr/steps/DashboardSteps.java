package globedr.steps;

import globedr.pages.DashboardPage;
import globedr.utils.DriverManager;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DashboardSteps {
  DashboardPage dashboardPage = new DashboardPage();

  @Then("I should be redirected to the dashboard")
  public void iShouldBeRedirectedToTheDashboard() {
   try {
      dashboardPage.waitForDashboardPage();
      assertTrue(DriverManager.getCurrentUrl().contains("dashboard"));
     assertTrue(dashboardPage.isDashboardPageDisplayed());
    } catch (AssertionError e) {
      DriverManager.takeScreenshot("dashboard_not_found.png");
      throw e;
    }
  }
}
