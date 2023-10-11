package com.ait.demoqa.pages.bookStore;

import com.ait.demoqa.pages.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookStorePage extends BasePage {

  public BookStorePage(WebDriver driver) {
   super(driver);
  }

  @FindBy(id= "searchBox")
  WebElement searchBox;

  public BookStorePage enterBookName(String book) {
    typeWithJSExecutor(searchBox, book, 0, 100);
    return this;
  }

  @FindBy(xpath = "//span[@class='mr-2']/a")
  WebElement bookName;

  public BookStorePage verifyBookName(String book) {
    Assert.assertTrue(isTextPresent(bookName, book));
    return this;
  }

  @FindBy(id = "login")
  WebElement loginButton;
  public LoginPage clickOnLoginButton() {
    click(loginButton);
    return new LoginPage(driver);
  }

  public BookStorePage selectBook() {
    clickWithJSExecutor(bookName, 0, 100);
    return this;
  }

  @FindBy(css = ".text-right.fullButton")
  WebElement addBookButton;

  public BookStorePage addToCollectionButton() {
    clickWithJSExecutor(addBookButton, 0, 600);
    pause(1000);
    driver.switchTo().alert().accept();
    return this;
  }

  @FindBy(id ="delete-record-undefined")
  List<WebElement> bookList;

  @FindBy(id = "closeSmallModal-ok")
  WebElement okButton;

  public ProfilePage deleteBook() {
    bookList.get(0).click();
    pause(500);
    click(okButton);
    pause(100);
    driver.switchTo().alert().accept();
    return new ProfilePage(driver);
  }
}
