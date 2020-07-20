package StepDefinition;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;

    @Before
    public void runBeforeClass()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void runAfterClass()
    {
        driver.quit();
    }
}
