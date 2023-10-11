package com.ait.demoqa.utils;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener implements WebDriverListener {

  Logger logger = LoggerFactory.getLogger(MyListener.class);

  @Override
  public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
    WebDriverListener.super.onError(target, method, args, e);
    logger.info("Have a problem Miss!");
    logger.info("Object target: " + target.toString());
    logger.info("===================================");
    logger.info("Method name --> " + method.getName());
    logger.info("===================================");
    logger.info("InvocationTargetExeption --> " + e.getTargetException());
    logger.info("===================================");

    int i = new Random().nextInt(1000) + 1000;
    String link = "screenshots/screen_" + i + ".png";
    logger.info("Screen with error --> " + link);

    WebDriver driver = (ChromeDriver) target;
    TakesScreenshot screenshot = (TakesScreenshot) driver;

    File tmp = screenshot.getScreenshotAs(OutputType.FILE);
    try {
      Files.copy(tmp,new File(link));
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    WebDriverListener.super.beforeFindElement(driver, locator);
    logger.info("Find element -->" + locator);
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    WebDriverListener.super.afterFindElement(driver, locator, result);
    logger.info("Location of element -->" + result.getLocation());
  }

  @Override
  public void beforeFindElements(WebDriver driver, By locator) {
    WebDriverListener.super.beforeFindElements(driver, locator);
    logger.info("Find elements -->" + locator);
  }

  @Override
  public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
    WebDriverListener.super.afterFindElements(driver, locator, result);
    logger.info("List of elements is " + result.size());
  }
}
