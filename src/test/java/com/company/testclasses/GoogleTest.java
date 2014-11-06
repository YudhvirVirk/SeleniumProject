package com.company.testclasses;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.company.util.Excel;

public class GoogleTest {
	private WebDriver driver;
	
    @BeforeMethod
    public void launchBrowser(){
    	driver=new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
	
	@Test
	public void verifyLink() throws Exception{
		Excel excel = new Excel();
		excel.setExcel("src/test/resources/Data/Text.xls", "Sheet1");
		driver.get("https://google.co.in/");
		driver.findElement(By.id("gbqfq")).sendKeys(excel.getCellValue(1, 1));
		driver.findElement(By.id("gbqfb")).click();
		//ol[@id='rso']/div[@class='srg']/li[1]//h3/a
		Assert.assertTrue(driver.findElement(By.xpath("//ol[@id='rso']/div[@class='srg']/li[1]//h3/a")).getText().toUpperCase().contains( (excel.getCellValue(1, 1)).toUpperCase() ));
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
