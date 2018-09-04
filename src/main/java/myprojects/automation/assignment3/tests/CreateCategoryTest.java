package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        EventFiringWebDriver driver = getConfiguredDriver();
        String login  = "webinar.test@gmail.com";
        String password = "Xcg7299bnSmMuRLp9ITw";
        String categoryName = "Test category";
        GeneralActions generalActions = new GeneralActions(driver);
        categoriesPage = new CategoriesPage(driver);
        // WebDriver driver = getConfiguredDriver();
        // ...

        // login
        generalActions.login(login, password);

        // create category
        generalActions.createCategory(categoryName);
        categoriesPage.filterCategoriesByName();
        generalActions.waitForContentLoad();

        // check that new category appears in Categories table
        WebElement newCategory = driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'" + categoryName + "')]"));
        if (categoryName.equals(newCategory.getText())) {
            System.out.println("Category name displayed correctly!");
        }

        // finish script
        driver.quit();

    }
}
