package com.bodax.home.threads;

import com.bodax.home.FinanceUA;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
public class Thread2 implements Runnable {
    private Controller controller;
    private WebDriver driver2;
    private Property property;
    private FinanceUA financeUA;
    private boolean isActive = false;
    private ChromeOptions options;

    public Controller getController() {
        return controller;
    }

    public Thread2(Controller controller) {
        this.controller = controller;
        property = new Property();
        System.setProperty("webdriver.chrome.driver", property.getPathToDriver());
        options = new ChromeOptions();
        options.setBinary(new File("/chrome-win/chrome.exe"));
        options.addArguments("--window-size=1366,768", "--ignore-certificate-errors");
     //   options.addArguments( "--headless", "--disable-gpu","--window-size=1366,768", "--ignore-certificate-errors");
    }

    @Override
    public void run() {
        try {
            driver2 = new ChromeDriver(options);
            System.out.println("OK - Chrome driver loaded correctly");
            financeUA = new FinanceUA(driver2, getController());
            financeUA.loadPage();
            financeUA.clickEnterToAccount();
            financeUA.setCredentials(property.getLogin2(), property.getPass2());
            Thread.sleep(5000);
            while (true) {
                financeUA.addPropose();
                financeUA.setSaleOrBuy(controller.getWant2());
                financeUA.setValue(controller.getValue2());
                financeUA.setCurrency(controller.getCurrency2());
                financeUA.setRate(String.valueOf(controller.getRate2()));
                financeUA.setCity();
                financeUA.setDistrict(controller.getDistrict2());
                financeUA.setComment(controller.getComboBoxComment2().getValue());
                financeUA.setActualTime();
                financeUA.savePropose();
                isActive = true;
                Platform.runLater(() -> controller.getStatusLabel2().setTextFill(Color.web("#00ff14")));
                Platform.runLater(() -> controller.getStatusLabel2().setText(
                        "Активно"));
                Thread.sleep(50000);
                financeUA.deleteItemTest(String.valueOf(controller.getRate2()));
                Thread.sleep(1000);
                isActive = false;
                Platform.runLater(() -> controller.getStatusLabel2().setTextFill(Color.web("#ff8900")));
                Platform.runLater(() -> controller.getStatusLabel2().setText(
                        "Удалено"));
                Thread.sleep(2000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("[Finally Error] + Driver finished in finally " +
                    "section");
            Platform.runLater(() -> controller.getStatusLabel2().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel2().setText(
                    "Остановлено"));
            // driver2.quit();

        }
    }

    public void closeDriver() {
        getDriver2().quit();
    }

    public WebDriver getDriver2() {
        return driver2;
    }

    public void deleteByUser() throws InterruptedException {
        financeUA.loadPage();
        Thread.sleep(1000);
        if (isActive) {
            financeUA.deleteItemTest(String.valueOf(controller.getRate2()));
            Platform.runLater(() -> controller.getStatusLabel2().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel2().setText(
                    "Удалено"));
            Thread.sleep(500);
            Thread.sleep(1000);
        }
    }
}
