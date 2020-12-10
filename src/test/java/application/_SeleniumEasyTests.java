package application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class _SeleniumEasyTests {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/banjo/Documents/Chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void inputFormTest() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement dropdownItem = driver.findElement(By.cssSelector("#select-demo > option:nth-child(2)"));

        System.out.println(dropdownItem.getText());
        assert(dropdownItem.getText()).toLowerCase().contains("sunday");
    }

    @Test
    public void inputFormSelectionTest() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement dropdownItem = driver.findElement(By.cssSelector("#select-demo > option:nth-child(2)"));

        dropdownItem.click();

        WebElement daySelected = driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > " +
                "div:nth-child(4) > div.panel-body > p.selected-value"));

        assert(daySelected.getText()).contains("Day selected :- Sunday");
    }

    @Test
    public void inputFormAllSelectionsTest() {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        List<String> dropdownExpectedValues = new ArrayList<String>();
        dropdownExpectedValues.add("invalid");
        dropdownExpectedValues.add("invalid");
        dropdownExpectedValues.add("Sunday");
        dropdownExpectedValues.add("Monday");
        dropdownExpectedValues.add("Tuesday");
        dropdownExpectedValues.add("Wednesday");
        dropdownExpectedValues.add("Thursday");
        dropdownExpectedValues.add("Friday");
        dropdownExpectedValues.add("Saturday");


        for(int i = 2; i < 9; i++) {
            WebElement dropdownValue = driver.findElement(By.cssSelector("#select-demo > option:nth-child(" + i + ")"));
            String expectedValue = dropdownExpectedValues.get(i);
            //System.out.println(expectedValue);
            //System.out.println(dropdownValue.getText());
            assert(dropdownValue.getText()).contains(expectedValue);
        }
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
