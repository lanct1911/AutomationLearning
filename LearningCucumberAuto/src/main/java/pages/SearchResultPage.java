package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    private static final By SEARCH_FLD = By.xpath("//input[@type=\"text\"]");
    private static final By WEB_RESULT_TXT= By.xpath("//div[@class=\"rc\"]/div[@class=\"r\"]/a/h3");
    private static final By VIDEO_RESULT_TXT = By.xpath("//*[@id=\"rso\"]//div[@aria-level=\"3\"]");

    public SearchResultPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String getInputtedText()
    {
        return driver.findElement(SEARCH_FLD).getAttribute("value");
    }

    public void clickOnVideoInVideoModule()
    {
        driver.findElement(VIDEO_RESULT_TXT).click();
    }

    public List<String> getWebResultText()
    {
        List<WebElement> webResults = driver.findElements(WEB_RESULT_TXT);
        List<String> webResultText = new ArrayList<String>();

        for (WebElement text: webResults)
        {
            webResultText.add(text.getText().toLowerCase());
        }
        return webResultText;
    }

    public List<String> getVideoResultText()
    {
        List<WebElement> videoResults = driver.findElements(VIDEO_RESULT_TXT);
        List<String> videoResultText = new ArrayList<String>();
        for (WebElement text: videoResults)
        {
            videoResultText.add(text.getText().toLowerCase());
        }
        System.out.println(videoResultText);
        return videoResultText;
    }

    public boolean isSearchResultContainKeyword(List<String> resultText, String keyword)
    {
        boolean isContainKeyword=false ;
        for (int i = 0; i< resultText.size();i++)
        {
            if ((resultText.get(i)).contains(keyword))
                isContainKeyword=true;
            else isContainKeyword=false;
        }
        return isContainKeyword;

    }
}
