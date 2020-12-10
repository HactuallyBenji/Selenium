package application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class _UvicHomePageTests {


    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/banjo/Documents/Chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    // Exercise 1
    @Test
    public void navigateToUvicHome() throws  Exception{
        driver.navigate().to("https://www.uvic.ca/");

        driver.manage().window().maximize();
        // Check we are actually on the Uvic homepage

        WebElement Title = driver.findElement(By.xpath("//*[@id=\"uv-header\"]/div[2]/div/div/a"));

        assert(Title.getText().toLowerCase().contains("university of victoria"));
        //Thread.sleep(5000);
    }

//    // Test version of the next test cool
//
//    @Test
//    public void himmatTest() throws Exception{
//        driver.navigate().to("https://www.uvic.ca/");
//
//        driver.manage().window().maximize();
//
//        WebElement navbar = driver.findElement(By.xpath("//*[@id=\"uvic-nav\"]/div/div"));
//
//        List<WebElement> nav_links = navbar.findElements(By.cssSelector("a"));
//        List<String> expectedNavItems = new ArrayList<>();
//        expectedNavItems.add("admissions");
//        expectedNavItems.add("academics");
//        expectedNavItems.add("research");
//        expectedNavItems.add("campus");
//        expectedNavItems.add("about uvic");
//        expectedNavItems.add("support uvic");
//
//        // w.click
//        for(int i = 0; i < 6; i++) {
//            assert(nav_links.get(i).getText().contains(expectedNavItems.get(i)));
//        }
//    }

    // Exercise 2
    @Test
    public void navigateToUvicCheckIfMenuBarIsAsExpected() throws  Exception{
        driver.navigate().to("https://www.uvic.ca/");

        driver.manage().window().maximize();
        // Check we are actually on the Uvic homepage


        List<String> expectedNavItems = new ArrayList<>();
        expectedNavItems.add("admissions");
        expectedNavItems.add("academics");
        expectedNavItems.add("research");
        expectedNavItems.add("campus");
        expectedNavItems.add("about uvic");
        expectedNavItems.add("support uvic");

        for(int i = 1; i < 7; i++) {
            WebElement menuItem = driver.findElement(By.xpath("//*[@id=\"uvic-nav\"]/div/div/ul/li[" + i + "]/a"));
            assert(menuItem.getText().toLowerCase().contains(expectedNavItems.get(i - 1)));
        }

        //Thread.sleep(5000);
    }

    // Exercise 3

    @Test
    public void checkSignInButton() throws Exception {
        driver.navigate().to("https://www.uvic.ca/");
        driver.manage().window().maximize();
        WebElement SignInButton = driver.findElement(By.xpath("//*[@id=\"uv-header\"]/div[1]/div[2]/div/div/div[2]/a[2]"));
        assert(SignInButton.getText().toLowerCase().contains("sign in"));
        //Thread.sleep(3000);
    }

    // Exercise 4

    @Test
    public void navigateToUvicCheckIfPhoneNumberIsAsExpected() throws  Exception{
        driver.navigate().to("https://www.uvic.ca/");

        driver.manage().window().maximize();

        WebElement PhoneNumber = driver.findElement(By.xpath("/html/body/footer/div/div[3]/div/div/div[2]/div/div[1]/ul/li[1]/a"));
        assert(PhoneNumber.getText().toLowerCase().contains("1-250-721-7211"));
        //Thread.sleep(5000);
    }



    @After
    public void tearDown(){
        System.out.println("");
        if(driver!=null){
            driver.close();
            driver.quit();
        }
    }
}
