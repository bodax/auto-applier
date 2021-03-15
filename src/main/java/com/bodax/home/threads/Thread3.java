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
public class Thread3 implements Runnable {
    private Controller controller;
    private WebDriver driver3;
    private Property property;
    private boolean isActive = false;
    private FinanceUA financeUA;
    private ChromeOptions options;

    public Controller getController() {
        return controller;
    }

    public Thread3(Controller controller) throws IOException {
        this.controller = controller;
        property = new Property();
        System.setProperty("webdriver.chrome.driver",   property.getPathToDriver());
        options = new ChromeOptions();
        options.setBinary(new File("/chrome-win/chrome.exe"));
       options.addArguments("--window-size=1366,768", "--ignore-certificate-errors");
       // options.addArguments("--headless", "--disable-gpu", "--window-size=1366,768", "--ignore-certificate-errors");
    }

    @Override
    public void run() {
        try {
            driver3 = new ChromeDriver(options);
            System.out.println("OK - Chrome driver loaded correctly");
            financeUA = new FinanceUA(driver3, getController());
            financeUA.loadPage();
            financeUA.clickEnterToAccount();
            financeUA.setCredentials(property.getLogin3(), property.getPass3());
            Thread.sleep(5000);
            while (true) {
                financeUA.addPropose();
                financeUA.setSaleOrBuy(controller.getWant3());
                financeUA.setValue(controller.getValue3());
                financeUA.setCurrency(controller.getCurrency3());
                financeUA.setRate(String.valueOf(controller.getRate3()));
                financeUA.setCity();
                financeUA.setDistrict(controller.getDistrict3());
                financeUA.setComment(controller.getComboBoxComment3().getValue());
                financeUA.savePropose();
                isActive = true;
                Platform.runLater(() -> controller.getStatusLabel3().setTextFill(Color.web("#00ff14")));
                Platform.runLater(() -> controller.getStatusLabel3().setText(
                        "Активно"));
                Thread.sleep(50000);
                financeUA.deleteItemTest(String.valueOf(controller.getRate3()));
                Thread.sleep(1000);
                isActive = false;
                Platform.runLater(() -> controller.getStatusLabel3().setTextFill(Color.web("#ff8900")));
                Platform.runLater(() -> controller.getStatusLabel3().setText(
                        "Удалено"));
                Thread.sleep(2000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("[Finally Error] + Driver finished in finally " +
                    "section");
            Platform.runLater(() -> controller.getStatusLabel3().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel3().setText(
                    "Остановлено"));
            driver3.quit();
        }
    }

    public void closeDriver() {
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver3;
    }

    public void deleteByUser() throws InterruptedException {
        financeUA.loadPage();
        Thread.sleep(1000);
        if (isActive) {
            financeUA.deleteItemTest(String.valueOf(controller.getRate3()));
            Platform.runLater(() -> controller.getStatusLabel3().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel3().setText(
                    "Удалено"));
            Thread.sleep(1000);
        }
    }
}
