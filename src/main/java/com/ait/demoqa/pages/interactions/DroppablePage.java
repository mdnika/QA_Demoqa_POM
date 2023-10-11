package com.ait.demoqa.pages.interactions;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DroppablePage extends BasePage {

  public DroppablePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "draggable")
  WebElement dragMe;

  @FindBy(id = "droppable")
  WebElement dropHer;
  public DroppablePage actionDragMe() {
    pause(1000);
    new Actions(driver).dragAndDrop(dragMe,dropHer).perform();

    return this;
  }

  public DroppablePage assertDropped(String text) {
    Assert.assertTrue(isTextPresent(dropHer, text));
    return this;
  }

  public DroppablePage dropBy(int x, int y) {
    pause(1000);
    //get coordinates dragMe(from)
    int xOffset1 = dragMe.getLocation().getX();
    int yOffset1 =dragMe.getLocation().getY();
    System.out.println("xOffset1 --> " + xOffset1 + " yOffset1 --> " + yOffset1);
    //get coordinates dropHere(to)
    int xOffset = dropHer.getLocation().getX();
    int yOffset =dropHer.getLocation().getY();
    System.out.println("xOffset --> " + xOffset + " yOffset --> " + yOffset);

   xOffset = (xOffset - xOffset1) + x;
   yOffset = (yOffset - yOffset1) + y;

   new Actions(driver).dragAndDropBy(dragMe,xOffset,yOffset).perform();
    return this;
  }
}
