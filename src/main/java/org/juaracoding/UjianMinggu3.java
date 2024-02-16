package org.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UjianMinggu3 {

    public static void main(String[] args) {

        String path = ("C:\\MyTools\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = ("https://www.saucedemo.com/");
        driver.get(url);
        System.out.println("Open web eCommerce");

        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        WebElement btnlogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnlogin.click();

        //validasi, Assert expected actual
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Utils.assertEqualsCustom(currentUrl, expectedUrl);

        //tambah validasi get text Swag Labs
        String excpectedTxt = "Swag Labs";
        String appLogo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Utils.assertEqualsCustom(appLogo, excpectedTxt);

        Utils.delay(2);
        WebElement btnIconMenu = driver.findElement(By.xpath("//button[contains@id='react-burger-menu-btn']"));
        btnIconMenu.click();
        Utils.delay(1);
        WebElement logout = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logout.click();

        WebElement btnAddCart = driver.findElement(By.xpath("//[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        btnAddCart.click();

        Utils.delay(2);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement cartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shopping_cart_container']")));

        if (cartElement.isDisplayed()){
            System.out.println("Berhasil memasukkan barang ke keranjang belanja");
        } else {
            System.out.println("Gagal memasukkan barang ke keranjang belanja");
        }
        //navigate back
        driver.navigate().back();


        Utils.delay(3);
        driver.quit();
    }
}
