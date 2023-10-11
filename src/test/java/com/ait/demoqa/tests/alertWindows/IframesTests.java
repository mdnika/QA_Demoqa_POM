package com.ait.demoqa.tests.alertWindows;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.alertWindows.IframesPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

  @BeforeMethod
  public void precondition(){
    new HomePage(driver).getAlertsFrameWindows();
  }

  @Test
  public void iframeTest(){
    new SidePanel(driver).selectFrames();
    new IframesPage(driver).returnListOfIframes().switchToFrameByIndex(2);
  }

  @Test
  public void switchToIframeByIdTest(){
    new SidePanel(driver).selectFrames();
    new IframesPage(driver).switchToIframeById();
  }

  @Test
  public void switchToNestedIframesTest(){
    new SidePanel(driver).selectNestedFrames();
    new IframesPage(driver).switchToNestedIframes();

  }
}
