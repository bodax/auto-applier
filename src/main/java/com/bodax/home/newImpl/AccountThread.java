package com.bodax.home.newImpl;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.Controller;
import sample.Property;

import java.io.File;
import java.io.IOException;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class AccountThread implements Runnable {

    private Controller controller;
    private WebDriver driver1;
    private Property property;
    private Applier applier;
    private boolean isActive = false;
    private ChromeOptions options;

    private static Logger log = LoggerFactory.getLogger(AccountThread.class);

    public Controller getController() {
        return controller;
    }

    public AccountThread(Controller controller) throws IOException {
        log.info("Start Thread 1, init constructor");
        this.controller = controller;
        property = new Property();
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        options = new ChromeOptions();
       // options.setBinary(new File("D:\\Java\\com\\bodax\\home\\FinanceUa\\resources\\chrome-win\\chrome-win\\chrome.exe"));
        options.setBinary(new File("/chrome-win/chrome.exe"));
        options.addArguments( "--window-size=1366,768", "--ignore-certificate-errors");

        // options.addExtensions(new File("adbblock.crx")); "--headless", "--disable-gpu",
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                driver1 = new ChromeDriver(options);
                log.info("OK - Chrome driver loaded correctly");
                applier = new Applier(driver1, getController());
                Thread.sleep(2000);
                applier.loadPage();
                Thread.sleep(2000);
                applier.clickEnterToAccount();
                Thread.sleep(2000);
                applier.setCredentials(property.getLogin1(),
                    property.getPass1());
                Thread.sleep(5000);
                while (!Thread.currentThread().isInterrupted()) {
                    applier.addPropose();
                    Thread.sleep(2000);
                    applier.setSaleOrBuy(controller.getWant1());
                    applier.setValue(controller.getValue1());
                    applier.setCurrency(controller.getCurrency1());
                    applier.setRate(String.valueOf(controller.getRate1()));
                    applier.setCity();
                    applier.setDistrict(controller.getDistrict1());
                    applier.setComment(controller.getComboBoxComment1().getValue());
                    applier.setActualTime();
                    applier.savePropose();
                    isActive = true;
                    Platform.runLater(() -> controller.getStatusLabel1().setTextFill(Color.web("#00ff14")));
                    Platform.runLater(() -> controller.getStatusLabel1().setText("Активно"));
                    Thread.sleep(15000);
                    applier.deleteItemTest(String.valueOf(controller.getRate1()));
                    Thread.sleep(5000);
                    isActive = false;
                    Platform.runLater(() -> controller.getStatusLabel1().setTextFill(Color.web("#ff8900")));
                    Platform.runLater(() -> controller.getStatusLabel1().setText("Удалено"));
                    Thread.sleep(2000);
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("[Finally Error] + Driver finished in " +
                    "finally section");
                Platform.runLater(() -> controller.getStatusLabel1().setTextFill(Color.web("#ff0000")));
                Platform.runLater(() -> controller.getStatusLabel1().setText(
                    "Остановлено"));
                driver1.quit();
            }
        }
    }

    public void closeDriver() throws IOException {
        getDriver1().quit();
    }

    public WebDriver getDriver1() throws IOException {
        return driver1;
    }

    public void deleteByUser() throws InterruptedException {
        applier.loadPage();
        Thread.sleep(1000);
        if (isActive) {
            applier.deleteItemTest(String.valueOf(controller.getRate1()));
            Platform.runLater(() -> controller.getStatusLabel1().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel1().setText(
                "Удалено"));
            Thread.sleep(500);
        }
    }
}


