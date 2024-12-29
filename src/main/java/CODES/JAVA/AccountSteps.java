package CODES.JAVA;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);

    @When("I go to the login page")
    public void iGoToLoginPage() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    @When("I create an account with {string}, {string}, {string}, {string}")
    public void iCreateAnAccount(String firstName, String lastName, String email, String password) {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        createAccountPage.enterFirstName(firstName);
        createAccountPage.enterLastName(lastName);
        createAccountPage.enterEmail(email);
        createAccountPage.enterPassword(password);
        createAccountPage.enterConfirmPassword(password);
        createAccountPage.clickCreateAccountButton();
    }

    @When("I login with {string} and {string}")
    public void iLoginWith(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedIn() {
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
}
