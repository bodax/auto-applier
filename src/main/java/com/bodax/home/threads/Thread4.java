package com.bodax.home.threads;

import java.io.File;
import java.io.IOException;
import com.bodax.home.FinanceUA;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sample.Controller;
import sample.Property;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Thread4 implements Runnable {
    private Controller controller;
    private WebDriver driver4;
    private Property property;
    private boolean isActive = false;
    private FinanceUA financeUA;
    private ChromeOptions options;

    public Controller getController() {
        return controller;
    }

    public Thread4(Controller controller) throws IOException {
        this.controller = controller;
        property = new Property();
        System.setProperty("webdriver.chrome.driver",
            property.getPathToDriver());
        options = new ChromeOptions();
        options.setBinary(new File("/chrome-win/chrome.exe"));
       options.addArguments("--window-size=1366,768", "--ignore-certificate-errors");
      //  options.addArguments( "--headless", "--disable-gpu","--window-size=1366,768", "--ignore-certificate-errors");
    }

    @Override
    public void run() {
        try {
            driver4 = new ChromeDriver(options);
            System.out.println("OK - Chrome driver loaded correctly");
            financeUA = new FinanceUA(driver4, getController());
            financeUA.loadPage();
            financeUA.clickEnterToAccount();
            financeUA.setCredentials(property.getLogin4(), property.getPass4());
            Thread.sleep(5000);
            while (true) {
                financeUA.addPropose();
                financeUA.setSaleOrBuy(controller.getWant4());
                financeUA.setValue(controller.getValue4());
                financeUA.setCurrency(controller.getCurrency4());
                financeUA.setRate(String.valueOf(controller.getRate4()));
                financeUA.setCity();
                financeUA.setDistrict(controller.getDistrict4());
                financeUA.setComment(controller.getComboBoxComment4().getValue());
                financeUA.savePropose();
                isActive = true;
                Platform.runLater(() -> controller.getStatusLabel4().setTextFill(Color.web("#00ff14")));
                Platform.runLater(() -> controller.getStatusLabel4().setText(
                    "Активно"));
                Thread.sleep(50000);
                financeUA.deleteItemTest(String.valueOf(controller.getRate4()));
                Thread.sleep(1000);
                isActive = false;
                Platform.runLater(() -> controller.getStatusLabel4().setTextFill(Color.web("#ff8900")));
                Platform.runLater(() -> controller.getStatusLabel4().setText(
                    "Удалено"));
                Thread.sleep(2000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("[Finally Error] + Driver finished in finally " +
                "section");
            Platform.runLater(() -> controller.getStatusLabel4().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel4().setText(
                "Остановлено"));
            driver4.quit();
        }
    }

    public void closeDriver() {
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver4;
    }

    public void deleteByUser() throws InterruptedException {
        financeUA.loadPage();
        Thread.sleep(1000);
        if (isActive) {
            financeUA.deleteItemTest(String.valueOf(controller.getRate4()));
            Platform.runLater(() -> controller.getStatusLabel4().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel4().setText(
                "Удалено"));
            Thread.sleep(1000);
        }
    }
}
