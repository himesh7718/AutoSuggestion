import org.openqa.selenium.chrome.ChromeDriver;

class Config {

   static void launchBrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver", driverPath());
        Driver.driver = new ChromeDriver();
        Driver.driver.get("https://www.amazon.com/");
    }

    static void closeBrowser(){
       Driver.driver.quit();
    }

    // Below method supports for 2 different platform. (1. Mac and 2. Windows) and browser chrome version should be 74
    private static String driverPath() throws Exception {
        String path = null;
        String osType = System.getProperty("os.name");
        System.out.println("Operating system is : "+osType);

        try{
            if(osType.contains("Mac")){
                path = "./chromeDriver/chromedriver";
            } else if(osType.contains("Windows")){
                path = "./chromeDriver/chromedriver.exe";
            }
        } catch (Exception e){
            throw new Exception("OS type is neither Macbook nor Windows"+e);
        }
        return path;
    }

}
