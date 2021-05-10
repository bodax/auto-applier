package com.bodax.home.threads;

import java.io.File;
import java.io.IOException;

import com.bodax.home.FinanceUA;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sample.MainController;
import sample.Property;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Thread5 implements Runnable {
    private MainController controller;
    private  WebDriver driver5;
    private  Property property;
    private boolean isActive = false;
    private FinanceUA financeUA;
    private ChromeOptions options;

    public MainController getController() {
        return controller;
    }

    public Thread5(MainController controller)  {
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
            driver5 = new ChromeDriver(options);
            System.out.println("OK - Chrome driver loaded correctly");
            financeUA = new FinanceUA(driver5, getController());
            financeUA.loadPage();
            financeUA.clickEnterToAccount();
            financeUA.setCredentials(property.getLogin5(), property.getPass5());
            Thread.sleep(5000);
            while (true) {
                financeUA.addPropose();
                financeUA.setSaleOrBuy(controller.getWant5());
                financeUA.setValue( controller.getValue5());
                financeUA.setCurrency(controller.getCurrency5());
                financeUA.setRate(String.valueOf(controller.getRate5()));
                financeUA.setCity();
                financeUA.setDistrict(controller.getDistrict5());
                financeUA.setComment(controller.getComboBoxComment5().getValue());
                financeUA.savePropose();
                isActive=true;
                Platform.runLater(() -> controller.getStatusLabel5().setTextFill(Color.web("#00ff14")));
                Platform.runLater(() -> controller.getStatusLabel5().setText("Активно"));
                Thread.sleep(50000);
                financeUA.deleteItemTest(String.valueOf(controller.getRate5()));
                Thread.sleep(1000);
                isActive=false;
                Platform.runLater(() -> controller.getStatusLabel5().setTextFill(Color.web("#ff8900")));
                Platform.runLater(() -> controller.getStatusLabel5().setText("Удалено"));
                Thread.sleep(2000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("[Finally Error] + Driver finished in finally section");
            Platform.runLater(() -> controller.getStatusLabel5().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel5().setText("Остановлено"));
            driver5.quit();
        }
    }

    public void closeDriver() {
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver5;
    }
    public void deleteByUser() throws InterruptedException {
        financeUA.loadPage();
        Thread.sleep(1000);
        if (isActive){
            financeUA.deleteItemTest(String.valueOf(controller.getRate5()));
            System.out.println("Item deleted by user correctly");
            Platform.runLater(() -> controller.getStatusLabel5().setTextFill(Color.web("#ff0000")));
            Platform.runLater(() -> controller.getStatusLabel5().setText("Удалено"));
            Thread.sleep(1000);
        }
    }
}
