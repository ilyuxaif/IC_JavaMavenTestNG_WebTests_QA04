import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    @Test
    public void testMenuStartTitle() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\TestTools\\chromedriver.exe";
        String url = "https://99-bottles-of-beer.net/";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']"));
        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//div[@id='main']/h2"));
        String actualResult = h2.getText();

        String expectedResult = "Welcome to 99 Bottles of Beer";
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
