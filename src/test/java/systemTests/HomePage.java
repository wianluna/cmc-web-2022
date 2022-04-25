package systemTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(text(), 'Добавить образец')]/..")
    private WebElement addSpecimenBtn;

    @FindBy(xpath = "//*[contains(text(), 'Поиск')]")
    private WebElement findBtn;

    @FindBy(xpath = "//*[@name = 'specimens_id']")
    private WebElement idField;

    @FindBy(xpath = "//*[@name = 'source']")
    private WebElement sourceField;

    public void clickFindBtn() {
        findBtn.click();
    }

    public void clickAddSpecimenBtn() {
        addSpecimenBtn.click();
    }

    public WebElement getAddSpecimenBtn() {
        return addSpecimenBtn;
    }

    public WebElement getFindBtn() {
        return findBtn;
    }

    public WebElement getIdField() {
        return idField;
    }

    public WebElement getSourceField() {
        return sourceField;
    }
}