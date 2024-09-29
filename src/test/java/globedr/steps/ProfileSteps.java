package globedr.steps;

import globedr.pages.ProfilePage;
import globedr.utils.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

public class ProfileSteps {
  ProfilePage profilePage = new ProfilePage();

  @And("I navigate to the profile page")
  public void iNavigateToTheProfilePage() {
    DriverManager.navigateTo("https://globedr.com/profile/info");
  }

  @When("I update the profile with the following personal information:")
  public void iUpdateTheProfileWithTheFollowingPersonalInformation(DataTable dataTable) {
    List<Map<String, String>> profileData = dataTable.asMaps(String.class, String.class);
    for (Map<String, String> data : profileData) {
      profilePage.updateProfile(
        data.get("fullName"),
        data.get("email"),
        data.get("title"),
        data.get("phoneNumber"),
        data.get("workPhone"),
        data.get("unit"),
        data.get("gender"),
        data.get("dateOfBirth")
      );
    }
  }

//  @When("I update the profile with the following address information:")
//  public void iUpdateTheProfileWithTheFollowingAddressInformation(DataTable dataTable) {
//    List<Map<String, String>> addressData = dataTable.asMaps(String.class, String.class);
//    for (Map<String, String> data : addressData) {
//      profilePage.updateAddress(
//        data.get("country"),
//        data.get("currentCountry"),
//        data.get("city"),
//        data.get("district"),
//        data.get("ward"),
//        data.get("address")
//      );
//    }
//  }

  @Then("I should see the profile updated successfully")
  public void iShouldSeeTheProfileUpdatedSuccessfully() {
    try {
      String actualMessage = profilePage.getToastMessage();
      assertTrue(actualMessage.contains("Thành công"));
    } catch (AssertionError e) {
      DriverManager.takeScreenshot("update_profile_faild.png");
      throw e;
    }
  }


  @Then("I should see the profile updated failed")
  public void iShouldSeeTheProfileUpdatedFailed() {
    try {
      String actualMessage = profilePage.getToastMessage();
      assertTrue(actualMessage.contains("Vui lòng kiểm tra lại thông tin và thử lại"));
    } catch (AssertionError e) {
      DriverManager.takeScreenshot("update_profile_faild.png");
      throw e;
    }
  }
}
