package globedr.suites.login;

import globedr.pages.LoginPage;
import globedr.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

  private WebDriver driver;
  private LoginPage loginPage;

  private static final String BASE_URL = "https://globedr.com/signin";
  private static final String MESS_ERR_INVALID = "Vui lòng kiểm tra lại số điện thoại, email hoặc mật khẩu của bạn";
  private static final String MESS_ERR_EMPTY = "Vui lòng kiểm tra lại thông tin và thử lại";
  private static final String USERNAME_EXPECTED = "Công Võ";

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver(); // Khởi tạo trình duyệt Chrome
    driver.get(BASE_URL); // Mở trang đăng nhập
    loginPage = new LoginPage(driver); // Khởi tạo đối tượng trang đăng nhập
  }

  @DataProvider(name = "loginCredentials")
  public Object[][] loginData() {
    return new Object[][] {
      { "0971879660", "067795161", false, MESS_ERR_INVALID }, // Thông tin đăng nhập không hợp lệ
      { "0971879660", "06779516", true, USERNAME_EXPECTED }, // Thông tin đăng nhập hợp lệ
      { "0971879660", "", false, MESS_ERR_EMPTY }, // Mật khẩu trống
      { "", "", false, MESS_ERR_EMPTY }, // Số điện thoại và mật khẩu đều trống
      { "", "2312313113", false, MESS_ERR_EMPTY } // Số điện thoại trống
    };
  }
//
  @Test(dataProvider = "loginCredentials", description = "Kiểm tra đăng nhập với nhiều bộ thông tin")
  public void testLogin(String phoneNumber, String password, boolean isSuccess, String expectedMessage) {
    loginPage.login(phoneNumber, password); // Thực hiện đăng nhập

    if (isSuccess) {
      DashboardPage dashboardPage = new DashboardPage(driver); // Nếu đăng nhập thành công, khởi tạo trang dashboard
      Assert.assertEquals(dashboardPage.getUserName(), expectedMessage, "Không đúng tên người dùng mong đợi!");
    } else {
      String actualMessage = loginPage.getToastMessage(); // Nếu đăng nhập không thành công, lấy thông báo lỗi
      Assert.assertEquals(actualMessage, expectedMessage, "Không đúng thông báo lỗi mong đợi!");
    }
  }


  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      driver.quit(); // Đóng trình duyệt sau khi kiểm tra xong
    }
  }
}
