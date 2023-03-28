package mantis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mantis.pages.MantisSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;

public class IssueTest {
    private WebDriver driver;
    private MantisSite mantisSite;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        driver.manage().window().maximize();
    }

    @Test
    public void IssueZereforTest() throws InterruptedException, URISyntaxException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();
        mantisSite.IssuesCreating("zerefor", "zerefor2");
        mantisSite.getMainPage().goToViewIssuesPage();
        mantisSite.SearchSummary("zerefor");
        Thread.sleep(5000);

        mantisSite.getMainPage().goToViewIssuesPage();
        String summary = mantisSite.getViewIssuesPage().getSummary();
        Assertions.assertNotEquals("zerefor", summary);
        String viewIssueURL = mantisSite.getViewIssuesPage().getViewIssueURL();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/view_all_bug_page.php", viewIssueURL);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}