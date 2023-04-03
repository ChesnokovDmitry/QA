package org.example.AllureTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class AllureAbstractTest {

    static EventFiringWebDriver eventDriver;

    @BeforeAll
    public static void init() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.ALL);
        logs.enable(LogType.PERFORMANCE, Level.ALL);
        logs.enable(LogType.PROFILER, Level.ALL);
        logs.enable(LogType.SERVER, Level.ALL);

        options.setCapability(CapabilityType.LOGGING_PREFS, logs);
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("start-maximized");

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "FFLogs.log");

        eventDriver = new EventFiringWebDriver(new FirefoxDriver(options));
        eventDriver.register(new MyWebDriverEventListener());

        eventDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void goTo() {
        Assertions.assertDoesNotThrow(() -> getWebDriver().navigate().to("https://www.aqua-shop.ru/"), "Page not found");
    }

    @AfterEach
    public void close() {
        if (eventDriver != null)
            eventDriver.quit();
    }

    public WebDriver getWebDriver() {
        return eventDriver;
    }
}