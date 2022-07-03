import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11_WebTests {

    String url = "https://99-bottles-of-beer.net/";
    String chromeDriver = "webdriver.chrome.driver";
    String driverPath = "C:\\TestTools\\chromedriver.exe";

    @Test
    public void TC_11_01() {

    /**
    * Подтвердите, что на странице по базовой ссылке в правом верхнем углу пользователь видит заголовок 99 Bottles of Beer
    *
    * Шаги:
    * 1. Открыть вебсайт на базовой странице
    * 2. Считать заголовок в правом верхнем углу
    * 3. Подтвердить, что текст заголовка соответствует ожидаемому
    * 4. Закрыть браузер
    */
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement header = driver.findElement(By.xpath("//h1"));
        String actualResult = header.getText();

        Assert.assertEquals(actualResult, "99 Bottles of Beer");

        driver.quit();
    }

    @Test
    public void TC_11_02() {
    /**
    * Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
     *
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Считать название последнего пункта меню
     * 3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
     * 4. Закрыть браузер
    */
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement lastMenuElement = driver.findElement
                (By.xpath("//div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));
        String actualResult = lastMenuElement.getText();

        Assert.assertEquals(actualResult, "Submit new language".toUpperCase());

        driver.quit();

    }

    @Test
    public void TC_11_03() {
    /**
    * Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language
     *
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт меню Submit new Language
     * 3. Считать название подзаголовка последнего пункта меню
     * 4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
     * 5. Закрыть браузер
    */

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement lastMenuElementLink = driver.findElement
                (By.xpath("//div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));
        lastMenuElementLink.click();

        WebElement lastMenuElement = driver.findElement
                (By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']"));

        String actualResult = lastMenuElement.getText();
        System.out.println(actualResult);

        driver.quit();
    }

    @Test
    public void TC_11_04() {
    /**
     * Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html , первый пункт подменю называется 0-9
     *
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Считать название первого подзаголовка
     * 3. Подтвердить, что название подменю соответствует ожидаемому
     * 4. Закрыть браузер
     */
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url + "abc.html");

        WebElement firstLangItem = driver.findElement
                (By.xpath("//div[@id=\"wrap\"]/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"));

        Assert.assertEquals(firstLangItem.getText(), "0-9");
        driver.quit();
    }

    @Test
    public void TC_11_06() {
        /**
         * TC_11_06 Подтвердите, что имена создателей сайта:
         Oliver Schade
         Gregor Scheithauer
         Stefan Scheler

         Шаги:
         Напишите самостоятельно (найдите информацию о создателях на сайте, и опишите шаги для навигации и исполнения тест кейса)
         */

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url + "team.html");

        String name1 = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='main']/h3[contains(text(), 'Oliver Schade')]")).getText();

        Assert.assertEquals(name1, "Oliver Schade");

        String name2 = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='main']/h3[contains(text(), 'Gregor Scheithauer')]")).getText();

        Assert.assertEquals(name2, "Gregor Scheithauer");

        String name3 = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='main']/h3[contains(text(), 'Stefan Scheler')]")).getText();

        Assert.assertEquals(name3, "Stefan Scheler");




        driver.quit();
    }

    @Test
    public void TC_11_11() {
    /**
     * Подтвердите, что если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     * пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка
     *
     * Error: Precondition failed - Incomplete Input.
     *
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Нажать на кнопку Submit Language
     * 3. Подтвердить, что на странице показана ошибка
     * 4. Подтвердить, что текст ошибки соответствует ожидаемому
     * 5. Закрыть браузер
     */
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url + "submitnewlanguage.html");

        driver.findElement(By.xpath("//input[contains(@type, 'submit')]")).click();
        String errMessage = driver.findElement(By.xpath("//div[@id='main']/p")).getText();

        Assert.assertEquals(errMessage, "Error: Precondition failed - Incomplete Input.");

        driver.quit();
    }

    @Test
    public void TC_11_12() {
    /**
     Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html,
     пользователь нажмет кнопку Submit Language, не заполнив информацию в обязательных полях,
     будет показана ошибка с текстом

     Error: Precondition failed - Incomplete Input.

     Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input написаны с большой буквы,
     а слово failed  написано  с маленькой буквы.
     Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .

     Шаги:
     1. Открыть вебсайт на странице
     2. Нажать на кнопку Submit Language
     3. Считать текст ошибки
     4. Подтвердить requirenments
     5. Закрыть браузер
     */

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url + "submitnewlanguage.html");

        driver.findElement(By.xpath("//input[contains(@type, 'submit')]")).click();
        String errMessage = driver.findElement(By.xpath("//div[@id='main']/p")).getText();
        String[] errorMessage = errMessage.split(" ");

        Assert.assertEquals("Error".charAt(0), errorMessage[0].charAt(0));
        Assert.assertEquals("Precondition".charAt(0), errorMessage[1].charAt(0));
        Assert.assertEquals("failed".charAt(0), errorMessage[2].charAt(0));
        Assert.assertEquals("Incomplete".charAt(0), errorMessage[4].charAt(0));
        Assert.assertEquals("Input".charAt(0), errorMessage[5].charAt(0));

        driver.quit();
    }

    @Test
    public void TC_11_13() {
    /**
    *  Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html
     *  в первом пункте списка пользователь видит текст
     *
     * IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description),
     * the easier it will be for us and the faster your language will show up on this page. We don't have the time to
     * mess around with fixing your descriptions etc. Thanks for your understanding.
     *
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Считать текст
     * 3. Подтвердить, что текст соответствует ожидаемому
     * 4. Закрыть браузер
    */

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url + "submitnewlanguage.html");

        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form " +
                "(especially the language name and description), the easier it will be for us and the faster " +
                "your language will show up on this page. We don't have the time to mess around with fixing your " +
                "descriptions etc. Thanks for your understanding.";
        String actualResult = driver.findElement
                (By.xpath("//div[@id='main']/ul/li[contains(., 'IMPORTANT')]")).getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void TC_11_14() {
    /**
    * TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь увидит таблицу со
    * следующими названиями для первого и второго столбцов:
    * Language
    * Author
    *
    * Шаги:
    * 1. Открыть вебсайт на базовой странице
    * 2. Нажать на пункт меню Browse Languages
    * 3. Считать названия первого и второго столбцов таблицы
    * 3. Подтвердить, что названия соответствует ожидаемым
    * 4. Закрыть браузер
    */

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement selectMenuItem = driver.findElement(By.xpath("//a[@href='/abc.html']"));
        selectMenuItem.click();

        WebElement path = driver.findElement(By.xpath("//table[@id='category']/tbody/tr/th[1]"));
        String firstRow = path.getText();
        Assert.assertEquals(firstRow, "Language");

        path = driver.findElement(By.xpath("//table[@id='category']/tbody/tr/th[2]"));
        String secondRow = path.getText();
        Assert.assertEquals(secondRow, "Author");

        driver.quit();
    }

    @Test
    public void TC_11_15() {
    /**
    * TC_11_15 Подтвердите, что на странице по базовой ссылке  пользователь НЕ увидит новые комментарии,
    * если нажмет на пункты меню Top List → New Comments
    *
    * Шаги:
    * Придумать самостоятельно.
    */
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.xpath("//a[@href='/toplist.html']")).click();
        driver.findElement(By.xpath("//a[@href='./newcomments.html']")).click();

        String expectedResult = driver.findElement
                (By.xpath("//div[@id='main'][contains(., '{LIST}')]")).getText();
        String actualResult = "New Comments\n" + "{LIST}";

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void TC_11_21() {
    /**
    * Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html
    * пользователь видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом на красном фоне,
    * и что все буквы - capital
    *
    * Шаги:
    * 1. Открыть вебсайт на странице
    * 2. Считать слово IMPORTANT: из списка
    * 3. Подтвердить requirenments
    * 4. Закрыть браузер
    */

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url + "submitnewlanguage.html");

        String expectedResult = "IMPORTANT:";
        String bold = driver.findElement
                (By.xpath("//div[@id='main']/ul/li/span/b")).getTagName();
        Assert.assertEquals(bold, "b");

        WebElement important = driver.findElement
                (By.xpath("//div[@id='main']/ul/li/span[@style='background-color:red; color: white']"));
        Assert.assertEquals(important.getText(), expectedResult);

        String backgroundColor = important.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(backgroundColor), Color.fromString("#ff0000"));

        String color = important.getCssValue("color");
        Assert.assertEquals(Color.fromString("#ffffff"), Color.fromString(color));

        driver.quit();
    }
}
