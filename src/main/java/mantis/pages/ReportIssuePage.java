package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URISyntaxException;

public class ReportIssuePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#summary")
    private WebElement summaryField;

    @FindBy(css = "#description")
    private WebElement descriptionField;

    @FindBy(css = "[type='submit']")
    private WebElement submit;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public void IssuesCreating(String summary, String description) throws InterruptedException, URISyntaxException {
        summaryField.sendKeys(summary);
        descriptionField.sendKeys(description);
        submit.click();
    }
}