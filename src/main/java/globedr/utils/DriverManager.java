package globedr.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManager {
  private static WebDriver driver;
  private static WebDriverWait wait;
  private static final Logger logger = Logger.getLogger(DriverManager.class.getName());

  private DriverManager() {}

  public static synchronized void init(BrowserType browserType) {
    if (driver == null) {
      driver = createDriver(browserType);
      wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      driver.manage().window().maximize();
      logger.info("WebDriver initialized: " + browserType);
    }
  }

  private static WebDriver createDriver(BrowserType browserType) {
    switch (browserType) {
      case FIREFOX:
        return new FirefoxDriver();
      case CHROME:
      default:
        return new ChromeDriver();
    }
  }

  public static WebDriver getDriver() {
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
      wait = null;
    }
  }

  public static void takeScreenshot(String fileName) {
    try {
      Path directory = Paths.get("target", "screenshots");
      Files.createDirectories(directory);
      File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
      FileHandler.copy(screenshot, new File(directory.toString(), fileName));
      logger.info("Screenshot saved as " + directory.resolve(fileName));
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error taking screenshot: " + e.getMessage(), e);
    }
  }

  public static <T> T waitFor(ExpectedCondition<T> condition) {
    return wait.until(condition);
  }
  public static void waitForValue(By locator) {
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
  }
  public static WebElement findElement(By locator) {
    return getDriver().findElement(locator);
  }

  public static void navigateTo(String url) {
    getDriver().get(url);
  }

  public static String getCurrentUrl() {
   return getDriver().getCurrentUrl();
  }
}
