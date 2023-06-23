package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class ImageURLs {
    ChromeDriver driver;
    public ImageURLs()
    {
        System.out.println("Constructor: ImageURLs");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        driver.close();
        driver.quit();

    }

    
    public  void movieImage() throws InterruptedException{
        System.out.println("Start Test case: ImageURLs");

        // Navigate to URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(5000);

        // Locate all images of recommended movies Using Locator "XPath" //div[@class="sc-lnhrs7-4 fmmlKL"]//img
        List<WebElement> allImageLinks = driver.findElements(By.xpath("//img[starts-with(@src, 'https://assets-in.bmscdn.com/discovery-catalog/events/')]"));
        
        // // get recommended movies's image URLs Using Locator "XPath" //div[@class="sc-lnhrs7-4 fmmlKL"]//img.getAttribute(src)
        for(int i=0; i<allImageLinks.size(); i++){
            System.out.println("Image URL for the Recommended Movie: " + (allImageLinks.get(i).getAttribute("src")));
        }
    
        //Thread.sleep(2000);
        WebElement premiereSec =  driver.findElement(By.xpath("//img[@alt='Tvod Offer']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", premiereSec);

        List<WebElement> ele = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[5]/div/div/div/div[2]/div/div[1]/div[2]/a/div/div[3]"));
        for(WebElement e: ele) {
        System.out.println(e.getText());
       
        //     // Locate "name of 2nd premieres movie" Using Locator "XPath" //*[@id="https://in.bookmyshow.com/chennai/movies/mob-psycho-100-season-1/ET00359847-1"]/div/div[3]/div[1]/div
        //     WebElement name2ndMovie = driver.findElement(By.xpath("//*[@id=\"https://in.bookmyshow.com/chennai/movies/endeavour-series-8/ET00359055-1\"]/div/div[3]/div[1]/div"));
        
        //     // get text "name of 2nd premieres movie" Using Locator "XPath" //*[@id="https://in.bookmyshow.com/chennai/movies/mob-psycho-100-season-1/ET00359847-1"]/div/div[3]/div[1]/div.getText()
        //     System.out.println("Name of 2nd premieres movie is: " + name2ndMovie.getText());

        //     // Locate "language of 2nd premieres movie" Using Locator "XPath" //*[@id="https://in.bookmyshow.com/chennai/movies/mob-psycho-100-season-1/ET00359847-1"]/div/div[3]/div[2]/div
        //     WebElement language2ndMovie = driver.findElement(By.xpath("//*[@id=\"https://in.bookmyshow.com/chennai/movies/endeavour-series-8/ET00359055-1\"]/div/div[3]/div[2]/div"));
        
        //     // get text "language of 2nd premieres movie" Using Locator "XPath" //*[@id="https://in.bookmyshow.com/chennai/movies/mob-psycho-100-season-1/ET00359847-1"]/div/div[3]/div[2]/div.getText()
        //     System.out.println("Language of 2nd premieres movie is: " + language2ndMovie.getText());

        System.out.println("end Test case: ImageURLs");

    }
}
}
