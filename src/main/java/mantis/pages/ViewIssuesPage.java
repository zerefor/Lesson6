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
    private WebElement deleteIssueInput;

    @FindBy(css = "[value='OK']")
    private WebElement okButton;//

    @FindBy(css = "[value='Delete Issues']")
    private WebElement deleteButton;

    @FindBy(css = "#buglist tbody tr:first-child [class*='summary']")
    private WebElement firstIssueSummary;


    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public void deleteIssue(String search) throws InterruptedException {
        resetFilterButton.click();
        searchField.sendKeys(search);
        applyButton.click();
        checkBoxIssue.click();
        deleteIssueInput.click();
        okButton.click();
        deleteButton.click();
        resetFilterButton.click();
    }

    public String getSummary() {
        return firstIssueSummary.getText();
    }

    public String getViewIssueURL() {
        return driver.getCurrentUrl();
    }
}