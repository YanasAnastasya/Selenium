package UI;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageTests extends TestBase{

    @Test
    public void CheckingDropDownSearchPerson() {
        page.open();
        wait.until(ExpectedConditions.visibilityOf(page.button));
        page.inputModal.sendKeys("Ш");

        //act
        wait.until(ExpectedConditions.visibilityOf(page.hints));
        String actualResultIssue = page.hints.getText();


        //assert
        assertTrue(page.hints.isDisplayed(), "Список не отобразился");
        assertTrue(actualResultIssue.contains("Ш"), "В тексте не найдено слово");
    }
}
