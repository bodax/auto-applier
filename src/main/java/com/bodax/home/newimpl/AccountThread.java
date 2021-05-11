package com.bodax.home.newimpl;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class AccountThread implements Runnable {

    private WebDriver driver;
    private Applier applier;
    private boolean isActive = false;
    private ChromeOptions options;
    private static Logger log = LoggerFactory.getLogger(AccountThread.class);
    private AccountFrame accountFrame;
    private final Property properties;

    public AccountThread(AccountFrame accountFrame) {
        this.accountFrame = accountFrame;
        this.properties = new Property();
        System.setProperty("webdriver.chrome.driver", properties.getPathToDriver());
        options = new ChromeOptions();
        options.setBinary(new File(properties.getChromePath()));
        options.addArguments("--window-size=1366,768", "--headless", "--disable-gpu", "--ignore-certificate-errors");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                driver = new ChromeDriver(options);
                log.info("OK - Chrome driver loaded correctly");
                applier = new Applier(driver);
                Thread.sleep(2000);
                applier.loadPage();
                Thread.sleep(2000);
                applier.clickEnterToAccount();
                Thread.sleep(2000);
                applier.setCredentials(accountFrame.getLogin(), accountFrame.getPassword());
                Thread.sleep(5000);
                while (!Thread.currentThread().isInterrupted()) {
                    applier.addPropose();
                    Thread.sleep(2000);
                    applier.setSaleOrBuy(accountFrame.getWant());
                    applier.setValue(accountFrame.getValue());
                    applier.setCurrency(accountFrame.getCurrency());
                    applier.setRate(String.valueOf(accountFrame.getRate()));
                    applier.setCity();
                    applier.setDistrict(accountFrame.getDistrict());
                    applier.setComment(accountFrame.getComboBoxComment());
                    applier.setActualTime();
                    applier.savePropose();
                    isActive = true;

                    Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#00ff14")));
                    Platform.runLater(() -> accountFrame.getStatusLabel().setText("Активно"));
                    Thread.sleep(50000);
                    applier.deleteItemTest(String.valueOf(accountFrame.getRate()));
                    isActive = false;
                    Thread.sleep(2000);
                    Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#ff8900")));
                    Platform.runLater(() -> accountFrame.getStatusLabel().setText("Удалено"));
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                log.error("Error during execution {}", e.getMessage());
                Thread.currentThread().interrupt();
            } finally {
                log.error("Web Driver finished in finally section");
                Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#ff0000")));
                Platform.runLater(() -> accountFrame.getStatusLabel().setText("Остановлено"));
                driver.quit();
            }
        }
    }

    public void closeDriver() {
        driver.quit();
    }

    public void deleteByUser() throws InterruptedException {
        applier.loadPage();
        Thread.sleep(1000);
        if (isActive) {
            applier.deleteItemTest(String.valueOf(accountFrame.getRate()));
            Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> accountFrame.getStatusLabel().setText("Удалено"));
            Thread.sleep(500);
        }
    }
}


