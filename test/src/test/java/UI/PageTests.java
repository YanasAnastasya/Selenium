package UI;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageTests extends TestBase{

    @Test
    public void CheckingDropDownSearchPerson() {
        page.open();
        wait.until(ExpectedConditions.visibilityOf(page.button));
        page.inputModal.sendKeys("�");

        //act
        wait.until(ExpectedConditions.visibilityOf(page.hints));
        String actualResultIssue = page.hints.getText();


        //assert
        assertTrue(page.hints.isDisplayed(), "������ �� �����������");
        assertTrue(actualResultIssue.contains("�"), "� ������ �� ������� �����");
    }
}
