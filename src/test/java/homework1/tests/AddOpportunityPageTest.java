package homework1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddOpportunityPageTest extends BaseTest {
    
    @Test(description = "Создание новой возможности на странице AddOpportunityPage",
            testName = "Успешное создание возможности (Opportunity)",
            priority = 1)
    public void checkAddNewOpportunity() {
        loginPage.openLoginPage();
        loginPage.loginInLoginPage("will", "will");
        mainPage.goToAddOpportunityPage();

        String uniqueName = "Test Opp " + System.currentTimeMillis();

        addOpportunityPage.createOpportunity(
                uniqueName, "Test", "12/31/2025", "10000",
                "Prospecting", "New Business", "Cold Call",
                "Call client", "Summer Campaign", "Test description"
        );

        addOpportunityPage.clickSave();

        Assert.assertTrue(opportunityPage.isOpportunityCreated(uniqueName),
                "Opportunity '" + uniqueName + "' не была создана");
    }
}
