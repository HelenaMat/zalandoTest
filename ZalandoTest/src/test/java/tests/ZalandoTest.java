package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZalandoTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Ange sökvägen till ChromeDriver
        System.setProperty("webdriver.chrome.driver", "sökväg\\till\\chromedriver.exe");
        // Skapa en instans av ChromeDriver
        driver = new ChromeDriver();
        // Gå till webbplatsen
        driver.get("https://www.zalando.se");
    }

    @Test
    public void testSearchProduct() {
        // Hitta sökrutan och skicka söktermen
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("skor");
        searchBox.submit();

        // Verifiera att sökresultat visas
        WebElement searchResults = driver.findElement(By.className("search-results"));
        assertTrue(searchResults.isDisplayed(), "Sökresultat visas inte korrekt");
    }

    @Test
    public void testAddToCart() {
        // Gå till en produktsida och lägg till produkten i varukorgen
        WebElement productLink = driver.findElement(By.xpath("//a[@class='product-link']"));
        productLink.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(), 'Lägg i varukorg')]"));
        addToCartButton.click();

        // Verifiera att produkten har lagts till i varukorgen
        WebElement cartIcon = driver.findElement(By.className("cart-icon"));
        assertTrue(cartIcon.isDisplayed(), "Produkten lades inte till i varukorgen");
    }

    @Test
    public void testLogin() {
        // Gå till inloggningssidan
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(), 'Logga in')]"));
        loginLink.click();

        // Ange användarnamn och lösenord och logga in
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("helena.matikainen@hotmail.se");
        passwordInput.sendKeys("Greku7219");
        loginButton.click();

        // Verifiera att inloggningen var framgångsrik
        WebElement userGreeting = driver.findElement(By.xpath("//div[@class='user-greeting']"));
        assertTrue(userGreeting.isDisplayed(), "Inloggning misslyckades");
    }

    @AfterEach
    public void tearDown() {
        // Stäng webbläsaren efter varje testfall
        if (driver != null) {
            driver.quit();
        }
    }
}
