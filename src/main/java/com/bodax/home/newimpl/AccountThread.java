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

    private final WebDriver driver;
    private final Applier applier;
    private static final Logger log = LoggerFactory.getLogger(AccountThread.class);
    private final AccountFrame accountFrame;

    public AccountThread(AccountFrame accountFrame) {
        this.accountFrame = accountFrame;
        System.setProperty("webdriver.chrome.driver", Property.getPathToDriver());
        ChromeOptions options = new ChromeOptions();
         options.setBinary(new File(Property.getChromePath()));
        options.addArguments("--window-size=1366,768", /*"--headless", "--disable-gpu"*/ "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        log.info("OK - Chrome driver loaded correctly");
        applier = new Applier(driver);
    }

    @Override
    public void run() {
        try {
            Platform.runLater(() -> accountFrame.getStatusLabel().setText("Запуск..."));
            Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#ffa500")));
            applier.loadPage();
            Thread.sleep(2000);
            applier.clickEnterToAccount();
            Thread.sleep(2000);
            applier.setCredentials(accountFrame.getLogin(), accountFrame.getPassword());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("The program was crashed by exception: {} ", e.getMessage(), e);
            Thread.currentThread().interrupt();
            closeDriver();
        }

        try {
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
                Thread.sleep(1000);
                Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#00ff14")));
                Platform.runLater(() -> accountFrame.getStatusLabel().setText("Активно"));
                Thread.sleep(50000);
                applier.deleteItemTest(String.valueOf(accountFrame.getRate()));
                Thread.sleep(2000);
                Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#ff8900")));
                Platform.runLater(() -> accountFrame.getStatusLabel().setText("Видалено"));
            }
        } catch (InterruptedException e) {
            log.error("Error during execution {}", e.getMessage(), e);
        } finally {
            log.error("Web Driver finished in finally section");
            Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> accountFrame.getStatusLabel().setText("Зупинено"));
            Thread.currentThread().interrupt();
            closeDriver();
        }
    }

    public void deleteAndClose() {
        try {
            deleteByUser();
        } catch (InterruptedException e) {
            log.error("Cant delete item: {}", e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
        closeDriver();
    }

    //TODO: make private
    public void closeDriver() {
        driver.close();
        driver.quit();
    }

    //TODO: make private
    public void deleteByUser() throws InterruptedException {
            applier.loadPage();
            applier.deleteItemTest(String.valueOf(accountFrame.getRate()));
            Platform.runLater(() -> accountFrame.getStatusLabel().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> accountFrame.getStatusLabel().setText("Видалено"));
            Thread.sleep(500);
    }
}
