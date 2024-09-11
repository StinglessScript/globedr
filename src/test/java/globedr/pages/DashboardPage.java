package globedr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
  By lblUserName = By.xpath("//li[contains(@class,'nav-account')]//span");

  public DashboardPage(WebDriver driver) {
    super(driver);

  }

  public String getUserName() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(lblUserName)).getText();
  }


}
