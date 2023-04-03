package org.example.AllureTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MyUtils {
    private static final Logger logger = LoggerFactory.getLogger(MyWebDriverEventListener.class);

    public static void makeScreenshot(WebDriver driver, String filename) {
        File name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./target/" + filename);

        try {
            FileUtils.copyFile(name, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printLog(LogEntries entries) {
        logger.info("{} log entries found", entries.getAll().size());

        for (LogEntry entry : entries) {
            logger.info("{} {} {}",
                    new Date(entry.getTimestamp()), entry.getLevel(), entry.getMessage()
            );
        }
    }
}
