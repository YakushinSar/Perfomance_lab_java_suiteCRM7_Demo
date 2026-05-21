package homework3.tests;

import homework3.dto.OpportunityDTO;
import homework3.pages.LoginPage;
import homework3.utils.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(retryAnalyzer = Retry.class)
public class AddOpportunityPageTest extends BaseTest {

    @Test(description = "Создание новой возможности на странице AddOpportunityPage",
            testName = "Успешное создание возможности (Opportunity)",
            priority = 1)
    public void checkAddNewOpportunity() {
        String uniqueName = "Test Opp " + System.currentTimeMillis();

        OpportunityDTO opportunity = new OpportunityDTO(
                uniqueName, "Test", "12/31/2025", "10000",
                "Prospecting", "New Business", "Cold Call",
                "Call client", "Summer Campaign", "Test description"
        );

        boolean isCreated = new LoginPage(driver, wait)
                .openLoginPage()
                .isPageOpened()
                .loginInLoginPage("will", "will")
                .isPageOpened()
                .goToAddOpportunityPage()
                .isPageOpened()
                .createOpportunity(opportunity)
                .clickSave()
                .isPageOpened()
                .isOpportunityCreated(uniqueName);

        Assert.assertTrue(isCreated, "Opportunity '" + uniqueName + "' не была создана");
    }
}