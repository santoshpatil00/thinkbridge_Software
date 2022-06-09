package selPkg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class TestWebSite {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\santoshk\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://jt-dev.azurewebsites.net/#/SignUp");
	WebElement dropdown=driver.findElement(By.xpath("//div[@id='language']"));
	dropdown.click();
    List<String> a = new ArrayList<>();
    List<WebElement> text = driver.findElements(By.xpath("//a[@class='ui-select-choices-row-inner']/div"));
	for (int i = 0; i < text.size(); i++) {
	        a.add(text.get(i).getText());
	    } 
	String[] exp = {"English", "Dutch"};
	for (WebElement ele: text) {
       for(int i=0; i<exp.length; i++) {
          if(ele.getText().equals(exp[i])) {
             System.out.println("Matched ");
                }
            }
	    }
	WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
	WebElement orgName=driver.findElement(By.xpath("//input[@id='orgName']"));
	WebElement email=driver.findElement(By.xpath("//input[@id='singUpEmail']"));
	WebElement chkBox=driver.findElement(By.xpath("//span[contains(text(),'I agree to the')]"));
	WebElement signUp=driver.findElement(By.xpath("//button[contains(text(),'Get Started')]"));	
    name.sendKeys("Santosh");
	orgName.sendKeys("Santosh");
	email.sendKeys("santoshkokate2020@gmail.com");
	chkBox.click();
	signUp.click();
	WebElement successMsg=driver.findElement(By.xpath("//span[contains(text(),'A welcome email has been sent. Please check your email.')]"));
    boolean bl=successMsg.isDisplayed();
	Assert.assertEquals(bl,true);
    driver.close();
}
}