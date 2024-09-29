package globedr.hooks;
import globedr.utils.BrowserType;
import globedr.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
  @Before
  public void setUp() {
    DriverManager.init(BrowserType.CHROME);
  }

  @After
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
