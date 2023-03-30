package com.bodax.home.newimpl.executor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0git
 */
public class Applier {

    private static final Logger log = LoggerFactory.getLogger(Applier.class);

    private final WebDriver driver;
    private final String website = "https://finance.i.ua/market/kiev/?";

    public Applier(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get(website);
        log.info("Website was loaded, {}", website);
    }

    public void clickEnterToAccount() {
        WebElement enterLink = driver.findElement(By.xpath("//a[contains(text(),'Вхід')]"));
        enterLink.click();
        log.info("OK - Clicked enter to account correctly");
    }

    public void setCredentials(String login, String password) {
        WebElement loginField = driver.findElement(By.xpath("//input[@name='login']"));
        loginField.sendKeys(login);
        WebElement passField = driver.findElement(By.xpath("//input[@name='pass']"));
        passField.sendKeys(password);
        WebElement enterBtn = driver.findElement(By.xpath("//div[@class='form_item form_item-submit']//input"));
        enterBtn.submit();
        log.info("OK - Set account credentials correctly");
    }

    public void addPropose() {
        driver.get(website);
        WebElement addProposeBtn = driver.findElement(By.xpath("//span[contains(text(),'добавить объявление')]"));
        addProposeBtn.click();
        log.info("OK - Click to add propose correctly");
    }

    public void setSaleOrBuy(String saleOrBuy) {
        WebElement setBuyOrSell = driver.findElement(By.xpath("//select[@id=\"market_record_record_type\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(setBuyOrSell).click().build().perform();
        if (saleOrBuy.equalsIgnoreCase("продать")) {
            WebElement saleField = driver.findElement(By.xpath("//select[@id=\"market_record_record_type\"]//option[2]"));
            saleField.click();
        } else if (saleOrBuy.equalsIgnoreCase("купить")) {
            WebElement buyField = driver.findElement(By.xpath("//select[@id=\"market_record_record_type\"]//option[1]"));
            buyField.click();
        }
        log.info("OK - Set sale or buy correctly");
    }

    public void setValue(String value) {
        WebElement setValue = driver.findElement(By.xpath("//input[@id='market_record_amount']"));
        setValue.sendKeys(value);
        log.info("OK - Set value correctly");
    }

    public void setCurrency(String currency) {
        WebElement currencyField = driver.findElement(By.xpath("//select[@id='market_record_currency_id']"));
        currencyField.click();
        WebElement currencyEl = driver.findElement(By.xpath(String.format("//option[contains(text(),'%s')]", currency)));
        currencyEl.click();
        log.info("OK - Set currency correctly");
    }

    public void setRate(String rate) {
        WebElement setRate = driver.findElement(By.xpath("//input[@id='market_record_ratio']"));
        setRate.sendKeys(rate);
        log.info("OK - Set rate correctly");
    }

    public void setCity() {
        WebElement setCityField = driver.findElement(By.xpath("//select[@id='market_record_location_id']"));
        Select select = new Select(setCityField);
        select.selectByVisibleText("Киев");
        log.info("OK - Set City correctly");
    }

    public void setDistrict(String district) {
        WebElement setDistrict = driver.findElement(By.xpath("//input[@id='market_record_district']"));
        setDistrict.sendKeys(district);
        log.info("OK - Set district correctly");
    }

    public void setComment(String comment) {
        WebElement actualTime = driver.findElement(By.xpath("//input[@id='market_record_comment']"));
        actualTime.sendKeys(comment);
        log.info("OK - Set comment correctly");
    }

    public void setActualTime() {
        WebElement actualTimeDropDown = driver.findElement(By.xpath("//select[@id='market_record_valid_until']"));
        Select select = new Select(actualTimeDropDown);
        select.selectByVisibleText("23:00");
        log.info("OK - Set actual correctly");
    }

    public void savePropose() {
        WebElement saveBtn = driver.findElement(By.xpath("//input[@name='commit']"));
        saveBtn.submit();
        log.info("OK - Add propose correctly");
    }

    public synchronized void deleteItemTest(String rate) {
        WebElement table = driver.findElement(By.xpath("//div[@class='data_container data-user']/table/tbody"));
        List<WebElement> trList = table.findElements(By.tagName("tr"));
        for (WebElement tr : trList) {
            if (tr.getText().contains(rate)) {
                List<WebElement> tdList = tr.findElements(By.tagName("td"));
                WebElement cellLink = tdList.get(5);
                WebElement delete = cellLink.findElement(By.tagName("span"));
                Actions action = new Actions(driver);
                action.moveToElement(delete).click().perform();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
                wait.until(ExpectedConditions.alertIsPresent()).accept();
                log.info("Item delete correctly");
                break;
            }
        }
    }
}

