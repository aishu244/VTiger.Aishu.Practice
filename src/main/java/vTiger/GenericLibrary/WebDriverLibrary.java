package vTiger.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLibrary {
	
	/**
	 * this method will maximise the window for webdriver drver
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
/**
 * this method will wait for 10 seconds page load 
 * @param driver
 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	/**
	 * this method will wait for 10 seconds element to be visible
	 * @param driver
	 * @param element
	 */
	//public void waitForElementTobeVisible(WebDriver driver,WebElement element)
//	{
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10L));
	//	wait.until(ExpectedConditions.visibilityOfAllElements(element));
	//}
	/**
	 * this method will wait for 10 seconds element to be clickable
	 * @param driver
	 * @param element
	 */
	//public void waitForElementTobeClickable(WebDriver driver,WebElement element)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
	//	wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
	/**
	 * this method will which is used to  wait for element and perform 
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClickOnElement(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<10)
		{
			try
			{
				element.click();
				break;
			}
			catch (Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * this method will perform right click on web page
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method will perform right click on particular web element
	 * @param driver
	 * @param element
	 */
	public void rightclickOnElement(WebDriver driver, WebElement element)
	{
		Actions act =  new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * this method will double click on webpage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver )
	{
		Actions act  =new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will dounle click on particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	/**
	 * thid method will drag and drop on webelement source to destination
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement src,WebElement dest)
	{
		Actions act = new  Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	/**
	 * this method will drag and drop for specific src location to target location
	 * @param driver
	 * @param x
	 * @param y
	 * @param src
	 */
	public void dragAndDrop(WebDriver driver,int x,int y,WebElement src)
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x, y).perform();
	}
	/**
	 * this method will handle drop down for visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
				
	}
	/**
	 * this method will handle drop down for value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element , String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method will handle by drop down for index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element , int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method will handle mouse hover on set off value using x and y co-ordinator
	 * @param driver
	 * @param xoff
	 * @param yoff
	 */
	public void handleMouseHover(WebDriver driver,int xoff,int yoff)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xoff, yoff).perform();
	}
	/**
	 * this method will handle mouse hover on web element
	 * @param driver
	 * @param element
	 */
	public void handleMouseHover(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * this method will switch to frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method will switch to frame by name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this method will switch to frame by web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method will switch to by parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * this method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
//	 * this method will handle aleart popup to switch to accept
	 * @param driver
	 */
	public void acceptAleart(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 *  this method will handle aleart popup to switch to dissmis
	 * @param driver
	 */
	public void dissmisAleart(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will return to popup for the caller
	 * @param driver
	 * @return
	 */
	public String getAleartText(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	/**
	 * this method will press the enter key
	 * @param driver
	 * @throws AWTException
	 */
	public void pressEnter(WebDriver driver) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * this method will switch to parent to any child or from any child  to parent  based on partial window title
	 * @param driver
	 * @param windowPartialTitle
	 */
	public void switchToWindow(WebDriver driver,String windowPartialTitle)
	{
		// get all window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//capture each window ids
		Iterator<String> it = windowIds.iterator();
		
		// navigate each window and get window title
		while(it.hasNext())
		{
			//capture individual window id
			String winId = it.next();
			
			//switch to window and capture current title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			
			//compare current title to parent title
			if(currentTitle.contains(windowPartialTitle))
			{
				break;
			}
			
		}
	}
	
	/**
	 *  this method will  take screenshot
	 * @param driver
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
       TakesScreenshot ts = (TakesScreenshot) driver;
      File src = ts.getScreenshotAs(OutputType.FILE);
      File dest = new File(".\\screenshots\\"+screenshotName+".png");
      FileUtils.copyFile(src, dest);
      
      return dest.getAbsolutePath();//use for extent reports
	}
	
	/**
	 * this method will scroll untill the specified element found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollby(0,"+y+")",element);
	}
	/**
	 * this method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	
	
	
}
