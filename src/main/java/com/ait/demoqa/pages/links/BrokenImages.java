package com.ait.demoqa.pages.links;

import com.ait.demoqa.pages.BasePage;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenImages extends BasePage {

  public BrokenImages(WebDriver driver) {
    super(driver);
  }

@FindBy(tagName = "img")
  List<WebElement> images;

  public BrokenImages checkBrokenImeges() {
    System.out.println("We have: " + images.size() + " images");
    for (int index = 0; index < images.size(); index++) {
      WebElement image = images.get(index);
      String imageURL = image.getAttribute("src");
      System.out.println("URL of image " + (index + 1) + " is: " + imageURL);
      verifyLinks(imageURL);
      try {

        boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
            .executeScript(
                "return(typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", image);
        if (imageDisplayed) {
          System.out.println("DISPLAYED - OK");
          System.out.println("***************************");
        } else {
          System.out.println("DISPLAYED _ BROKEN");
          System.out.println("*****************");
        }
      }catch (Exception e){
        System.out.println("ERROR");
      }
    }
    return this;
  }

}
