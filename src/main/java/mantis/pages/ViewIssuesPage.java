package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#filter-search-txt")
    private WebElement searchField;

    @FindBy(css = "[value='Apply Filter']")
    private WebElement applyButton; //

    @FindBy(css = "[name=reset_query_button]")
    private WebElement resetFilterButton;

    @FindBy(css = "[class='lbl']")
    private WebElement checkBoxIssue;

    @FindBy(css = "[name=action] [value='DELETE']")
    private WebElement deleteIssue;

    @FindBy(css = "[value='OK']")
    private WebElement okButton;//

    @FindBy(css = "[value='Delete Issues']")
    private WebElement deleteButton;

    @FindBy(css = "#buglist tbody tr:first-child [class*='summary']")
    private WebElement firstIssue;


    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public void FindSummary(String search) throws InterruptedException {
        resetFilterButton.click();
        searchField.sendKeys(search);
        applyButton.click();
        checkBoxIssue.click();
        deleteIssue.click();
        okButton.click();
        deleteButton.click();
        resetFilterButton.click();
    }

    public String getSummary() {
        return firstIssue.getText();
    }

    public String getViewIssueURL() {
        return driver.getCurrentUrl();
    }
}