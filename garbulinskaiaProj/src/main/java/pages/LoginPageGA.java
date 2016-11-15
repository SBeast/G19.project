package pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class LoginPageGA {

    WebDriver driver;
    Logger logger;
    final String errorInput = "Can not work with input emailLogin ";
    final String errorButton = "Can not work with button ";
    final String errorForgotPass = "Can not work with Forgot password";


    @FindBy(id = "emailLogin")
    WebElement inputEmailLogin;

    @FindBy(id = "password")
    WebElement inputPassWord;

    @FindBy(xpath = ".//input[@value='Login >>']")
    WebElement button;

    @FindBy(id = "emailloginreset")
    WebElement forgotPassEmail;

    @FindBy(id = "checkagreement")
    WebElement checkbox;

    @FindBy(xpath = ".//*[@href=\"http://greatagentusa.com/\"]")
    WebElement logo;

    @FindBy(xpath = ".//*[@href=\"../ready-for-a-personal-demo/\"]")
    WebElement requestADemo;

    @FindBy(xpath = ".//*[@id='divforterms']/a")
    WebElement termsOfServiceAgreement;

    @FindBy(id = "menu-item-4")
    WebElement product;

    @FindBy(className = "menu-item-295")
    WebElement brokersOwners;


    public LoginPageGA(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /**
     * Method open browser and Login Page
     */
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.get("http://greatagentusa.com/login/");
            logger.info("Page Login was opened");
        } catch (Exception e) {
            logger.error("Can not work with browser");
            Assert.fail("Can not work with browser");
        }
    }

    /**
     * Method closes Login page and Browser
     */
    public void closeLoginPageAndBrowser() {
        driver.quit();
        logger.info("Page Login and Browser were closed");
    }

    /**
     * Method enters emailLogin
     *
     * @param emailLogin
     */
    public void enterEmailLogin(String emailLogin) {
        try {
            inputEmailLogin.clear();
            inputEmailLogin.sendKeys(emailLogin);
            logger.info(emailLogin + " was entered");
        } catch (Exception e) {
            logger.error(errorInput + "emailLogin");
            Assert.fail(errorInput + "emailLogin");
        }
    }

    /**
     * Method enter password
     *
     * @param pass
     */
    public void enterPassWord(String pass) {
        try {
            inputPassWord.clear();
            inputPassWord.sendKeys(pass);
            logger.info(pass + " was entered");
        } catch (Exception e) {
            logger.error(errorInput + "PassWord");
            Assert.fail(errorInput + "PassWord");
        }
    }

    /**
     * Method clicks checkbox
     */
    public void clickCheckbox() {
        try {
            checkbox.isSelected();
            logger.info("Checkbox was already checked");
        } catch (Exception e) {
            checkbox.click();
            logger.info("We clicked checkbox");
        }
    }

    /**
     * Method click on button
     */
    public void clickButtonLogin() {
        try {
            button.click();
            logger.info("Button was clicked");
        } catch (Exception e) {
            logger.error(errorButton + " Login");
            Assert.fail(errorButton + " Login");
        }
    }

    /**
     * Method click on Logo
     */
    public void clickOnLogo() {
        try {
            logo.click();
            logger.info("Logo was clicked");
        } catch (Exception e) {
            logger.error("Can not work with Logo");
            Assert.fail("Can not work with Logo");
        }
    }


    /**
     * Method check if forgot password form present
     *
     * @return
     */
    public boolean isFormForgotPassPresent() {
        try {
            return forgotPassEmail.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method opens login page with Login and Pass
     * and click button Login
     *
     * @param emailLogin
     * @param pass
     */
    public void LogOn(String emailLogin, String pass) {
        openBrowserAndLoginPage();
        enterEmailLogin(emailLogin);
        enterPassWord(pass);
        clickCheckbox();
        clickButtonLogin();
    }

    /**
     * Method clicks Forgot password
     */
    public void clickForgotPass() {
        try {
            forgotPassEmail.click();
            logger.info("Forgot password was clicked");

        } catch (Exception e) {
            logger.error(errorForgotPass + " ForgotPass");
            Assert.fail(errorForgotPass + " ForgotPass");
        }
    }

    /**
     * Method clicks Request a demo
     */
    public void clickRequestADemo() {
        try {
            requestADemo.click();
            logger.info("Request a demo was clicked");

        } catch (Exception e) {
            logger.error("Can not work with Request a demo");
            Assert.fail("Can not work with Request a demo");
        }
    }

    /**
     * Method clicks Terms Of Service Agreement
     */
    public void clickTermsOfServiceAgreement() {
        try {
            termsOfServiceAgreement.click();
            logger.info("Terms of service agreement was clicked");

        } catch (Exception e) {
            logger.error("Can not work with Terms Of Service Agreement");
            Assert.fail("Can not work with Terms Of Service Agreement");
        }
    }

    /**
     * Method click Product
     */

    public void clickProduct() {
        try {
            product.click();
            logger.info("Product was clicked");

        } catch (Exception e) {
            logger.error("Can not work with Product");
            Assert.fail("Can not work with Product");
        }

    }

    /**
     * Method click Brokers & Owners
     */

    public void clickBrokersOwners() {
        try {
            waitSomeSec(5);
            brokersOwners.click();
            logger.info("Brokers & Owners was clicked");

        } catch (Exception e) {
            logger.error("Can not work with Brokers & Owners");
            Assert.fail("Can not work with Brokers & Owners");
        }

    }

    private void waitSomeSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}