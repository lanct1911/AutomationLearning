package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YoutubePage {
    WebDriver driver;
    private static final By VIDEO_TITLE_LBL = By.xpath("//h1/yt-formatted-string");
    private static final By CURRENT_TIME_LBL = By.xpath("//span[@class=\"ytp-time-current\"]");
    private static final By VIDEO_PLAY_OR_PAUSE_BTN = By.xpath("//button[@class=\"ytp-play-button ytp-button\"]");
    private static final By VIDEO_CONTAINER = By.id("movie_player");


    public YoutubePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String getVideoTitleText()
    {
        return driver.findElement(VIDEO_TITLE_LBL).getText().toLowerCase();
    }

    public void clickVideoContainer()
    {
        driver.findElement(VIDEO_CONTAINER).click();
    }

    public String getCurrentTimeText()
    {
        return driver.findElement(CURRENT_TIME_LBL).getText();
    }

    public String getTitleAttributeOfVideoPlayOrPauseButton()

    {
        return driver.findElement(VIDEO_PLAY_OR_PAUSE_BTN).getAttribute("title");
    }

    public void  pauseVideo(String pauseTime)
    {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(CURRENT_TIME_LBL,pauseTime));
        driver.findElement(VIDEO_CONTAINER).click();
    }

    public String getClassValueOfVideoPlayer()
    {
      return driver.findElement(VIDEO_CONTAINER).getAttribute("class");
    }
}
