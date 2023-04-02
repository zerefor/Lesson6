package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SelectorTests extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void SelectorsTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToReportIssuePage();
        Assertions.assertTrue(driver.findElement(By.cssSelector("#platform")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[tabindex='8'] [value='177']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement selectAll = driver.findElement(By.cssSelector("[tabindex='15']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectAll);

        Assertions.assertTrue(driver.findElement(By.cssSelector("tr:nth-child(13) label:first-child span[class='lbl padding-6']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("tr:last-child label [class='lbl padding-6']")).isDisplayed());
    }
}