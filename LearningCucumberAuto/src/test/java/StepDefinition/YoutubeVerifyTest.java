package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import pages.SearchResultPage;
import pages.YoutubePage;



public class YoutubeVerifyTest extends BaseTest {
    String keyword = "the beatles";
    Homepage homepage;
    SearchResultPage searchResultPage;
    YoutubePage youtubePage;

    @Given("^I am on Google search result page of keyword is \"the beatles\"$")
    public void searchWithKeyword()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
         homepage = new Homepage(driver);
        homepage.inputTextToSearch(keyword);
        homepage.clickSubmitButton();
    }

    @When("^I open the first video in Video carousel$")
    public void openFirstVideo() throws Throwable
    {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOnVideoInVideoModule();

    }
    @And("^I stop video after 10 seconds$")
    public void stopVideoAfterTenSeconds() throws Exception
    {

        youtubePage = new YoutubePage(driver);
        youtubePage.pauseVideo("0:11");
    }

    @Then("^The video title at Youtube page should match with search result$")
    public void verifyTitleOfVideo()  {
        Assert.assertTrue((youtubePage.getVideoTitleText()).contains(keyword));
    }

    @And("^State of video is correct$")
    public void verifyStateOfVideo() throws InterruptedException {

//        Thread.sleep(5000);
        Assert.assertTrue(youtubePage.getClassValueOfVideoPlayer().contains("paused-mode"));
        driver.quit();
    }

}
