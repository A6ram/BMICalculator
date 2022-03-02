import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BMICalculatorTesting {
    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void CategoryNormal(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("75");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category,"Your category is Normal");
    }
    @Test
    public void CategoryObese(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("98");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category,"Your category is Obese");
    }
    @Test
    public void CategoryOverweight(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("82");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category,"Your category is Overweight");
    }
    @Test
    public void CategoryStarvation(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("45");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category,"Your category is Starvation");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
