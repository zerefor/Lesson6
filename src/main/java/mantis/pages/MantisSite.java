package mantis.pages;

import org.openqa.selenium.WebDriver;

import java.net.URISyntaxException;

public class MantisSite {
    private final WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;
    private ViewIssuesPage viewIssuesPage;
    private ReportIssuePage reportIssuePage;

    public MantisSite(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);
        reportIssuePage = new ReportIssuePage(driver);
    }

    public void login(String login, String password) {
        loginPage.login(login);
        passwordPage.login(password);
    }

    public void IssuesCreating(String summary, String description) throws URISyntaxException, InterruptedException {
        reportIssuePage.issuesCreate(summary, description);
    }

    public void SearchSummary(String search) throws InterruptedException {
        viewIssuesPage.deleteSummary(search);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public PasswordPage getPasswordPage() {
        return passwordPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public ViewIssuesPage getViewIssuesPage() {
        return viewIssuesPage;
    }
}