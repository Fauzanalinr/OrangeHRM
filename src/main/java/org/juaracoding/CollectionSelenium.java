package org.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CollectionSelenium {

    public static void main(String[] args) {
        String path = ("C:\\MyTools\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = ("https://www.saucedemo.com/");
        driver.get(url);
        System.out.println("Open web eCommerce");

        //mencari jumlah object, size()
        List<WebElement> listTagInput = driver.findElements(By.xpath("//input"));
        System.out.println("Jumlah tag input = "+listTagInput.size());

        List<WebElement> listFormInput = driver.findElements(By.xpath("//input[contains(@class, 'form_input')]"));
        System.out.println("Jumlah form input = "+listFormInput.size());

        //user login
        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        WebElement btnlogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnlogin.click();

        List<WebElement> listItemPrice = driver.findElements(By.xpath("div[@class='inventory_item_price']"));
        System.out.println("Jumlah item price = "+listItemPrice.size());

        for (int i = 0; i < listItemPrice.size(); i++){
            System.out.println(listItemPrice.get(0).getText());
        }

        //Konversi dari string ke number (double)
        String priceOne = listItemPrice.get(0).getText();
        String priceOneReplace = priceOne.replace("$","");
        double priceOneConvert = Double.parseDouble(priceOneReplace);
        System.out.println(priceOneConvert+100);



        Utils.delay(3);
        driver.quit();
    }
}
