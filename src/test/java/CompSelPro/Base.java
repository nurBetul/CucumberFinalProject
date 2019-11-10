package CompSelPro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties prop;

    public static WebDriver getDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\nurbe\\IdeaProjects\\Cucumber_Maven_Final\\src\\test\\java\\CompSelPro\\global.properties");
        prop.load(fis);
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\nurbe\\Downloads\\chromedriver_77\\chromedriver.exe");
        //driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        return driver;
    }
}
