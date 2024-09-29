package globedr.steps;

import globedr.utils.BrowserType;
import globedr.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class DriverSteps {
  @Given("I open browser")
  public void iOpenBrowser() {
    DriverManager.init(BrowserType.CHROME);
  }

  @And("I wait for {int} seconds")
  public void iWaitForSeconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
