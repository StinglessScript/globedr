package globedr.pages;

import globedr.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage {
  // Thông tin cá nhân
  By txtFullName = By.xpath("//label[@translate='yourName']/preceding-sibling::input");
  By txtEmail = By.xpath("//label[@translate='email']/preceding-sibling::input");
  By txtTitle = By.xpath("//label[@translate='title']/preceding-sibling::input");
  By txtPhoneNumber = By.xpath("//label[@translate='phoneNumber']/preceding-sibling::input");
  By txtWorkPhone = By.xpath("//label[@translate='workPhone']/preceding-sibling::input");
  By txtUnit = By.xpath("//label[@translate='measurementUnit']/preceding-sibling::select");
  By txtGender = By.xpath("//label[@translate='gender']/preceding-sibling::select");
  By txtDateOfBirth = By.xpath("//label[@translate='dateBirth']/preceding-sibling::app-ng-date-gdr//input");

  // Địa chỉ
//  By txtCountry = By.xpath("//label[@translate='country']/preceding-sibling::select");
//  By txtCurrentCountry = By.xpath("//label[@translate='visitCountry']/preceding-sibling::select");
//  By selectCity = By.xpath("//label[@translate='city']/preceding-sibling::select");
//  By selectDistrict = By.xpath("//label[@translate='district']/preceding-sibling::select");
//  By selectWard = By.xpath("//label[@translate='ward']/preceding-sibling::select");
//  By txtAddress = By.xpath("//label[text()='Địa chỉ (số nhà, tên đường, tổ, khu phố)']/preceding-sibling::input");
  // lưu
  By btnSave = By.xpath("//a[@translate='save']");
  By toast = By.xpath("//div[contains(@class,'toast-message')]");
  public ProfilePage() {
  }

  public void enterFullName(String fullName) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtFullName));
    DriverManager.waitForValue(txtFullName);
    DriverManager.findElement(txtFullName).clear();
    DriverManager.findElement(txtFullName).sendKeys(fullName);
  }

  public void enterEmail(String email) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtEmail)).clear();
    DriverManager.findElement(txtEmail).sendKeys(email);
  }

  public void enterTitle(String title) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtTitle)).clear();
    DriverManager.findElement(txtTitle).sendKeys(title);
  }

  public void enterPhoneNumber(String phoneNumber) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtPhoneNumber)).clear();
      DriverManager.findElement(txtPhoneNumber).sendKeys(phoneNumber);
  }

  public void enterWorkPhone(String workPhone) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtWorkPhone)).clear();
    DriverManager.findElement(txtWorkPhone).sendKeys(workPhone);
  }

  public void enterUnit(String unit) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtUnit));
    new Select(DriverManager.findElement(txtUnit)).selectByVisibleText(unit);
  }

  public void selectGender(String gender) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtGender));
    new Select(DriverManager.findElement(txtGender)).selectByVisibleText(gender);
  }

  public void enterDateOfBirth(String dateOfBirth) {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtDateOfBirth));
    WebElement dateOfBirthElement = DriverManager.findElement(txtDateOfBirth);
    ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].value = '';", dateOfBirthElement);
      dateOfBirthElement.sendKeys(dateOfBirth);
  }
//  public void enterCountry(String country) {
//    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtCountry));
//    new Select(DriverManager.findElement(txtCountry)).selectByVisibleText(country);
//  }
//
//  public void enterCurrentCountry(String currentCountry) {
//    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtCurrentCountry));
//    new Select(DriverManager.findElement(txtCurrentCountry)).selectByVisibleText(currentCountry);
//  }
//
//  public void enterCity(String city) {
//    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(selectCity));
//    new Select(DriverManager.findElement(selectCity)).selectByVisibleText(city);
//  }

//  public void enterDistrict(String district) {
//    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(selectDistrict));
//    new Select(DriverManager.findElement(selectDistrict)).selectByVisibleText(district);
//  }
//
//  public void enterWard(String ward) {
//    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(selectWard));
//    new Select(DriverManager.findElement(selectWard)).selectByVisibleText(ward);
//  }
//
//  public void enterAddress(String address) {
//    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(txtAddress)).clear();
//    DriverManager.findElement(txtAddress).sendKeys(address);
//  }

  public void clickSaveButton() {
    DriverManager.findElement(btnSave).click();
  }

  public void updateProfile(String fullName, String email, String title, String phoneNumber, String workPhone, String unit,String gender, String dateOfBirth) {
    enterFullName(fullName);
    enterEmail(email);
    enterTitle(title);
    enterPhoneNumber(phoneNumber);
    enterWorkPhone(workPhone);
    enterDateOfBirth(dateOfBirth);
    selectGender(gender);
    enterUnit(unit);
    clickSaveButton();
  }

//  public void updateAddress(String country, String currentCountry, String city, String district, String ward, String address) {
//    enterCountry(country);
//    enterCurrentCountry(currentCountry);
//    enterCity(city);
//    enterDistrict(district);
//    enterWard(ward);
//    enterAddress(address);
//    clickSaveButton();
//  }

  public String getToastMessage() {
    DriverManager.waitFor(ExpectedConditions.visibilityOfElementLocated(toast));
    return DriverManager.findElement(toast).getText();
  }
}
