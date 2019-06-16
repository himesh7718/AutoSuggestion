import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

class methodsLib {

    void closePopup(){
        try {
            WebElement closePopup = Driver.driver.findElement(By.xpath(Locators.closePopup));
            closePopup.click();
        } catch (Exception e){
            System.out.println("Popup is not launched while launching the browser");
        }
    }

    void enterKeyword() throws Exception {
        try {
                WebElement enterKeyword = Driver.driver.findElement(By.id(Locators.textBox));
                enterKeyword.sendKeys(Data.keyword);
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    List<WebElement> collectAllAutoSuggestionList() throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.autoSuggestionList(Data.keyword.toLowerCase()))));
            List<WebElement> elementList = Driver.driver.findElements(By.xpath(Locators.autoSuggestionList(Data.keyword.toLowerCase())));
            System.out.println(elementList.size());
            for(int i=0; i < elementList.size(); i++){
                System.out.println(elementList.get(i).getText());
            }
            return elementList;
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    // Below method validates whether all the suggestion results are related to entered keyword or not.
    void validateAutoSuggestionResult(List<WebElement> result){
        for(int i=0; i<result.size(); i++){
            Assert.assertTrue(result.get(i).getText().contains(Data.keyword.toLowerCase()));
        }
    }

}
