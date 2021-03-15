package com.bodax.home.threads;

import java.io.File;
import java.io.IOException;

import com.bodax.home.FinanceUA;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.Controller;
import sample.Property;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Thread1 implements Runnable {
    private Controller controller;
    private WebDriver driver1;
    private Property property;
    private FinanceUA financeUA;
    private boolean isActive = false;
    private ChromeOptions options;

    private static Logger log = LoggerFactory.getLogger(Thread1.class);

    public Controller getController() {
        return controller;
    }

    public Thread1(Controller controller) throws IOException {
        log.info("Start Thread 1, init constructor");
        this.controller = controller;
        property = new Property();
        System.setProperty("webdriver.chrome.driver", property.getPathToDriver());
        options = new ChromeOptions();
        options.setBinary(new File("src/main/resources/chrome-win/chrome.exe"));
      //  options.setBinary(new File("/chrome-win/chrome.exe"));
        options.addArguments("--window-size=1366,768", "--ignore-certificate-errors");
       // options.addArguments( "--headless", "--disable-gpu","--window-size=1366,768", "--ignore-certificate-errors");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                driver1 = new ChromeDriver(options);
                log.info("OK - Chrome driver loaded correctly");
                financeUA = new FinanceUA(driver1, getController());
                Thread.sleep(2000);
                financeUA.loadPage();
                Thread.sleep(2000);
                financeUA.clickEnterToAccount();
                Thread.sleep(2000);
                financeUA.setCredentials(property.getLogin1(),
                    property.getPass1());
                Thread.sleep(5000);
                while (!Thread.currentThread().isInterrupted()) {
                    financeUA.addPropose();
                    Thread.sleep(2000);
                    financeUA.setSaleOrBuy(controller.getWant1());
                    financeUA.setValue(controller.getValue1());
                    financeUA.setCurrency(controller.getCurrency1());
                    financeUA.setRate(String.valueOf(controller.getRate1()));
                    financeUA.setCity();
                    financeUA.setDistrict(controller.getDistrict1());
                    financeUA.setComment(controller.getComboBoxComment1().getValue());
                    financeUA.setActualTime();
                    financeUA.savePropose();
                    isActive = true;
                    Platform.runLater(() -> controller.getStatusLabel1().setTextFill(Color.web("#00ff14")));
                    Platform.runLater(() -> controller.getStatusLabel1().setText("Активно"));
                    Thread.sleep(15000);
                    financeUA.deleteItemTest(String.valueOf(controller.getRate1()));
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
        financeUA.loadPage();
        Thread.sleep(1000);
        if (isActive) {
            financeUA.deleteItemTest(String.valueOf(controller.getRate1()));
            Platform.runLater(() -> controller.getStatusLabel1().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel1().setText(
                "Удалено"));
            Thread.sleep(500);
        }
    }
}


