import a1qa.Task2.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SteamTest {

    Driver dr = Driver.getInstanceDriver();
    WebDriver driver = dr.getDriver();


    @Test(description = "Open main page")
    public void openUrl(){
        WebElement logo = driver.findElement
                (By.xpath("//a[@class='header_installsteam_btn_content']"));
        Assert.assertTrue(logo.isDisplayed(),"Error on main page");
    }


    @Test(description = "Use login button")
    public void useLoginButton(){
        WebElement button = driver.findElement(By.xpath("//a[@class='global_action_link']"));
        button.click();
        WebElement passLine = driver.findElement(By.xpath("//input[contains(@type,'password')]"));
        Assert.assertTrue(passLine.isDisplayed(),"Error on login page");
    }
    @Test(description = "Input random strings, click Sign in button")
    public void inputStringsClickButton(){
        String login = "HomerSimson";

        String password = "newyork";
        driver.get("https://store.steampowered.com/login/?redir=&redir_ssl=1&snr=1_4_660__global-header");
        WebElement enterLogin = driver.findElement
                (By.xpath("//input[@class='newlogindialog_TextInput_2eKVn']"));
        enterLogin.sendKeys(login);
        WebElement enterPassword = driver.findElement
                (By.xpath("//input[contains(@type,'password')]"));
        enterPassword.sendKeys(password);
        WebElement signInButton = driver.findElement
                (By.xpath("//button[@class='newlogindialog_SubmitButton_2QgFE']"));
        signInButton.click();
        WebElement loading = driver.findElement
                (By.xpath("//div[@class='newlogindialog_LoadingSpinner_2rGL7 newlogindialog_Small_2G7Us']"));
        WebElement error = driver.findElement
                (By.xpath("//div[@class='newlogindialog_FormError_1Mcy9']"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(error.isDisplayed());
    }
}
