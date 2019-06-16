class Locators {

    static String closePopup = ".//*[contains(@class,'a-icon-close')]";
    static String textBox = "twotabsearchtextbox";
    static String autoSuggestionList(String keyword){
      return  ".//*[contains(text(),'"+keyword+"')]";
    }
}
