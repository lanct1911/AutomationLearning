package StepDefinition;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Homepage;
import pages.SearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class SearchTest extends BaseTest{

    String keyword = "the beatles";

    @Given("^I am on google page$")
    public void openGooglePage() throws Throwable
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @When("^I search keyword: \"the beatles\"$")
    public void inputKeywordSearch()throws Throwable
    {
        Homepage homepage = new Homepage(driver);
        homepage.inputTextToSearch(keyword);
        homepage.clickSubmitButton();
    }

    @Then("^I get the result containing \"the beatles\" keyword$")
    public void verifySearchResultContainingKeyword() throws Throwable
    {
        SearchResultPage searchResultPage=new SearchResultPage(driver);
        Assert.assertEquals(keyword, searchResultPage.getInputtedText());
        Assert.assertTrue(searchResultPage.isSearchResultContainKeyword(searchResultPage.getWebResultText(),keyword));
        Assert.assertTrue(searchResultPage.isSearchResultContainKeyword(searchResultPage.getVideoResultText(),keyword));
        driver.quit();
    }







}
