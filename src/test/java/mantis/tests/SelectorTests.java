package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectorTests extends BaseTest {
    private WebDriverWait wait;
    private MantisSite mantisSite;

    @Test
    public void SelectorsTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToReportIssuePage();
        Assertions.assertTrue(driver.findElement(By.cssSelector("#platform")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[tabindex='8'] [value='177']")).isDisplayed());

        WebElement selectAll = driver.findElement(By.cssSelector("[tabindex='15']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectAll);
        wait = new WebDriverWait(driver, 30, 500);

        Assertions.assertTrue(driver.findElement(By.cssSelector("tr:nth-child(13) label:first-child span[class='lbl padding-6']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("tr:last-child label [class='lbl padding-6']")).isDisplayed());
    }
}