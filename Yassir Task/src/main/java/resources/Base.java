package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    public static WebDriver driver;
    private Properties prop;
    public static WebDriverWait w;//test

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/resources/file.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        return driver;
    }
    public void saveScreenshot(String fileName, byte[] screenshotBytes) {
        try {
            // Create a folder named "screenshots" if it doesn't exist
            File screenshotDir = new File("screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs(); // Create directory and parent directories if necessary
            }

            // Save screenshot to a file in the "screenshots" folder with the given method name
            File screenshotFile = new File(screenshotDir, fileName + ".png");
            FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);

            // For demonstration, print method name and screenshot path
            System.out.println("Screenshot saved to: " + screenshotFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to take screenshot
    public byte[] takeScreenshot() {
        try {
            // Take screenshot as byte array
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
