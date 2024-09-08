package globedr.pages;

import globedr.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
  By txtUserName = By.id("UserName");
  By txtPassword = By.id("Password");
  By dlCountry = By.xpath("//button[@dropdowntoggle]");
  By btnLogin = By.xpath("//button[@translate='signIn']");
  By toastError = By.xpath("//div[contains(@class,'toast-message')]");

  public LoginPage(WebDriver driver) {
    super(driver);

  }

  public void enterUsername(String username) {
    driver.findElement(txtUserName).sendKeys(username);
  }

  public void enterPassword(String password) {
    driver.findElement(txtPassword).sendKeys(password);
  }

  public void clickLoginButton() {

    wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
  }

  //  getToastMessage
  public String getToastMessage() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(toastError));
    return driver.findElement(toastError).getText();
  }


  public void login(String username, String password) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(txtUserName));
    enterUsername(username);
    enterPassword(password);
    if(username != "") {
      wait.until(ExpectedConditions.textToBe(dlCountry, "+84"));
    }
    clickLoginButton();
  }
}
