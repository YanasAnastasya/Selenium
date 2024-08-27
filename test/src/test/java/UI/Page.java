package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (css = ".p")
    public WebElement button;

    @FindBy (css = ".p")
    public WebElement hints;

    @FindBy (css = ".p")
    public WebElement inputModal;

    public Page(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    public void open(){
        driver.navigate().to(url);
    }
    private String url = "";
}
