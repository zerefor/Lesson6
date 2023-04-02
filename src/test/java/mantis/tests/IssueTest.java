package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class IssueTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void IssueZereforTest() throws InterruptedException, URISyntaxException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuePage();
        mantisSite.issuesCreating("zerefor", "zerefor2");
        mantisSite.getMainPage().goToViewIssuesPage();
        mantisSite.deleteIssue("zerefor");
        mantisSite.getMainPage().goToViewIssuesPage();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String summary = mantisSite.getViewIssuesPage().getSummary();
        Assertions.assertNotEquals("zerefor", summary);
        String viewIssueURL = mantisSite.getViewIssuesPage().getViewIssueURL();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/view_all_bug_page.php", viewIssueURL);
    }
}