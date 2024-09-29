package globedr.pages;

import globedr.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage {
  private static final By DASHBOARD_HEADER = By.xpath("//h1[@translate='personalPage']");

  public void waitForDashboardPage() {
    try {
      DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER));
    } catch (Exception e) {
      DriverManager.takeScreenshot("DashboardPageError.png");
      throw e;
    }
  }

  public boolean isDashboardPageDisplayed() {
    WebElement header = DriverManager.findElement(DASHBOARD_HEADER);
    return header.isDisplayed();
  }
}
