package homework3.tests;

import homework3.dto.OpportunityDTO;
import homework3.factory.OpportunityFactory;
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
        // Используем Factory для генерации данных
        OpportunityDTO opportunity = OpportunityFactory.getRandomOpportunity();
        String uniqueName = opportunity.getName();

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

    @Test(description = "Создание возможности с конкретным Sales Stage",
            testName = "Создание возможности с заданным этапом",
            priority = 2)
    public void checkAddNewOpportunityWithSpecificStage() {
        // Используем Factory с конкретной стадией
        OpportunityDTO opportunity = OpportunityFactory.getOpportunityWithSalesStage("Closing");
        String uniqueName = opportunity.getName();

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