package globedr.pages;

import globedr.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
  By txtUserName = By.id("UserName");
  By txtPassword = By.id("Password");
  By dlCountry = By.xpath("//button[@dropdowntoggle]");
  By btnLogin = By.xpath("//button[@translate='signIn']");
  By toastError = By.xpath("//div[contains(@class,'toast-message')]");

  public LoginPage() {


  }

  public void enterUsername(String username) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtUserName)).sendKeys(username);
  }

  public void enterPassword(String password) {
    DriverManager.findElement(txtPassword).sendKeys(password);
  }

  public void clickLoginButton() {
    DriverManager.findElement(btnLogin).click();
  }


  public String getToastMessage() {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(toastError));
    return DriverManager.findElement(toastError).getText();
  }


  public void login(String username, String password) {
    enterUsername(username);
    enterPassword(password);
    System.out.println("username: " + username);
    if (username.matches("0[0-9]{9,10}")) {
      DriverManager.waitFor(ExpectedConditions.textToBe(dlCountry, "+84"));
    } else {
      try {
        Thread.sleep(2 * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    clickLoginButton();
  }
}
