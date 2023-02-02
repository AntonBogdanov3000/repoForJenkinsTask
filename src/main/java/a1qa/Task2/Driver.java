package a1qa.Task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

          private static Driver instanceDriver = null;
          private final WebDriver driver;

          private Driver(){
              //System.setProperty("webdriver.chrome.driver","/Users/Nastya/tools/chromedriver");
              driver = new ChromeDriver();
                      WebDriverManager.chromedriver().setup();
              driver.get("https://store.steampowered.com/");
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          }
          public static Driver getInstanceDriver(){
              if(instanceDriver == null){
                  instanceDriver = new Driver();
              }
              return instanceDriver;
          }
    public WebDriver getDriver(){
        return driver;
    }
}
