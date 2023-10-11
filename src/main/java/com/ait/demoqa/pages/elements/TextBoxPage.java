package com.ait.demoqa.pages.elements;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TextBoxPage extends BasePage {

  public TextBoxPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "currentAddress")
  WebElement currentAddress;
  @FindBy(id = "permanentAddress")
  WebElement permanentAddress;
  public TextBoxPage keyBoardEvent() {
    Actions actions = new Actions(driver);
    typeWithJSExecutor(currentAddress, "Friedrich straße", 0, 300);
   actions.keyDown(Keys.CONTROL);
   actions.sendKeys("a");
   actions.keyUp(Keys.CONTROL);
   actions.perform();

   //copy current address using CTRL + c
    actions.keyDown(Keys.CONTROL);
    actions.sendKeys("c");
    actions.keyUp(Keys.CONTROL);
    actions.perform();

    //press TAB to switch focus to permanent address
    actions.sendKeys(Keys.TAB).perform();
    //past current address
    actions.keyDown(Keys.CONTROL);
    actions.sendKeys("v");
    actions.keyUp(Keys.CONTROL);
    actions.perform();

    return this;
  }

  @FindBy(xpath = "(//*[@class='lt-mirror__canvas'])[1]")
  WebElement currentAddressText;
  @FindBy(xpath = "(//*[@class='lt-mirror__canvas'])[]")
  WebElement permanentAddressText;
  public TextBoxPage assertTextEquals() {
    Assert.assertEquals(currentAddress.getText(),permanentAddress.getText());
    return this;
  }
}
