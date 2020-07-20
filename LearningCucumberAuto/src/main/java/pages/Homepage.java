package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    WebDriver driver;
    private static final By SEARCH_FLD = By.xpath("//input[@type=\"text\"]");
    private static final By SUBMIT_BTN = By.xpath("//input[@name=\"btnK\"]");

    public Homepage(WebDriver driver)
    {
        this.driver=driver;
    }
     public void inputTextToSearch(String keyword)
     {
         driver.findElement(SEARCH_FLD).sendKeys(keyword);
     }
     public void clickSubmitButton()
     {
         driver.findElement(SEARCH_FLD).submit();
     }


    }
