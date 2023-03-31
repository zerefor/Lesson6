package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URISyntaxException;

public class IssueTest extends BaseTest {
    private MantisSite mantisSite;
    private WebDriverWait wait;

    @Test
    public void IssueZereforTest() throws InterruptedException, URISyntaxException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();
        mantisSite.issuesCreating("zerefor", "zerefor2");
        mantisSite.getMainPage().goToViewIssuesPage();
        mantisSite.searchIssue("zerefor");
        wait = new WebDriverWait(driver, 30, 500);
        mantisSite.getMainPage().goToViewIssuesPage();

        String summary = mantisSite.getViewIssuesPage().getSummary();
        Assertions.assertNotEquals("zerefor", summary);
        String viewIssueURL = mantisSite.getViewIssuesPage().getViewIssueURL();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/view_all_bug_page.php", viewIssueURL);
    }
}