

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonValidation extends ObjectRepo {

    @BeforeMethod
    void launchDriver() throws Exception{
        System.out.println(System.getProperty("user.dir"));
      Config.launchBrowser();
    }

    @Test(testName = "Validates whether all the suggestion results are related to entered keyword or not")
    void verifyAutoSuggestion() throws Exception {
        try {
            methodsLib.closePopup();
            methodsLib.enterKeyword();
            List<WebElement> autoSuggestionList = methodsLib.collectAllAutoSuggestionList();
            methodsLib.validateAutoSuggestionResult(autoSuggestionList);
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }

    @AfterMethod
    void closeBrowser(){
        Config.closeBrowser();
    }

}
