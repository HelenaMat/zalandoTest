import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestBase {
    // Deklarera Playwright-objekt
    private static Playwright playwright;
    // Deklarera Browser-objekt
    protected static Browser browser;
    // Deklarera BrowserContext-objekt
    protected BrowserContext context;

    @BeforeClass
    public static void setUp() {
        // Initialisera Playwright och skapa en webbläsarinstans
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @Before
    public void createNewContext() {
        // Skapa en ny kontext (webbläsarsession) för varje testfall
        context = browser.newContext();
    }

    @After
    public void closeContext() {
        // Stäng den aktuella kontexten efter varje testfall
        context.close();
    }

    @AfterClass
    public static void tearDown() {
        // Stäng webbläsaren och släpp Playwright-resurserna när alla test är klara
        browser.close();
        playwright.close();
    }
}
