package com.bodax.home.newimpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0git
 */
public class Applier {

    private final Logger log = LoggerFactory.getLogger(Applier.class);

    private final WebDriver driver;
    final String website = "https://finance.i.ua/market/kiev/?";

    public Applier(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get(website);
        log.info("Website was loaded, {}", website);
    }

    public void clickEnterToAccount() throws InterruptedException {
        WebElement enterLink = driver.findElement(By.xpath("//a[contains(text(),'Вход')]"));
        enterLink.click();
        Thread.sleep(3000);
        log.info("OK - Clicked enter to account correctly");
    }

    public void setCredentials(String login, String password) throws InterruptedException {
        WebElement loginField = driver.findElement(By.xpath("//input[@name='login']"));
        loginField.sendKeys(login);
        WebElement passField = driver.findElement(By.xpath("//input[@name='pass']"));
        passField.sendKeys(password);
        WebElement enterBtn = driver.findElement(By.xpath("//div[@class='form_item form_item-submit']//input"));
        enterBtn.submit();
        Thread.sleep(3000);
        log.info("OK - Set account credentials correctly");
    }

    public void addPropose() throws InterruptedException {
        driver.get(website);
        Thread.sleep(3000);
        WebElement addProposeBtn = driver.findElement(By.xpath("//span[contains(text(),'добавить объявление')]"));
        addProposeBtn.click();
        Thread.sleep(3000);
        log.info("OK - Click to add propose correctly");
    }

    public void setSaleOrBuy(String saleOrBuy) throws InterruptedException {
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
        Thread.sleep(3000);
        log.info("OK - Set sale or buy correctly");
    }

    public void setValue(String value) throws InterruptedException {
        WebElement setValue = driver.findElement(By.xpath("//input[@id='market_record_amount']"));
        setValue.sendKeys(value);
        Thread.sleep(2000);
        log.info("OK - Set value correctly");
    }

    public void setCurrency(String currency) throws InterruptedException {
        WebElement currencyField = driver.findElement(By.xpath("//select[@id='market_record_currency_id']"));
        currencyField.click();

        if (currency.equalsIgnoreCase("USD")) {
            WebElement currencyUSD = driver.findElement(By.xpath("//option[contains(text(),'USD')]"));
            currencyUSD.click();
        } else if (currency.equalsIgnoreCase("EUR")) {
            WebElement currencyEUR = driver.findElement(By.xpath("//option[contains(text(),'EUR')]"));
            currencyEUR.click();
        } else if (currency.equalsIgnoreCase("RUB")) {
            WebElement currencyRUB = driver.findElement(By.xpath("//option[contains(text(),'RUB')]"));
            currencyRUB.click();
        }
        Thread.sleep(2000);
        log.info("OK - Set currency correctly");
    }

    public void setRate(String rate) throws InterruptedException {
        WebElement setRate = driver.findElement(By.xpath("//input[@id='market_record_ratio']"));
        setRate.sendKeys(rate);
        Thread.sleep(2000);
        log.info("OK - Set rate correctly");
    }

    public void setCity() throws InterruptedException {
        WebElement setCityField = driver.findElement(By.xpath("//select[@id='market_record_location_id']"));
        Select select = new Select(setCityField);
        select.selectByVisibleText("Киев");
        Thread.sleep(2000);
        log.info("OK - Set City correctly");
    }

    public void setDistrict(String district) throws InterruptedException {
        WebElement setDistrict = driver.findElement(By.xpath("//input[@id='market_record_district']"));
        setDistrict.sendKeys(district);
        Thread.sleep(2000);
        log.info("OK - Set district correctly");
    }

    public void setComment(String comment) throws InterruptedException {
        WebElement actualTime = driver.findElement(By.xpath("//input[@id='market_record_comment']"));
        actualTime.sendKeys(comment);
        Thread.sleep(2000);
        log.info("OK - Set comment correctly");
    }

    public void setActualTime() throws InterruptedException {
        WebElement actualTimeDropDown = driver.findElement(By.xpath("//select[@id='market_record_valid_until']"));
        Select select = new Select(actualTimeDropDown);
        select.selectByVisibleText("23:00");
        Thread.sleep(2000);
        log.info("OK - Set actual correctly");
    }

    public void savePropose() throws InterruptedException {
        WebElement saveBtn = driver.findElement(By.xpath("//input[@name='commit']"));
        saveBtn.submit();
        Thread.sleep(2000);
        log.info("OK - Add propose correctly");
    }

    public void deleteItemTest(String rate) throws InterruptedException {
        WebElement table = driver.findElement(By.xpath("//div[@class='data_container data-user']/table/tbody"));
        List<WebElement> trList = table.findElements(By.tagName("tr"));
        for (WebElement tr : trList) {
            if (tr.getText().contains(rate)) {
                List<WebElement> tdList = tr.findElements(By.tagName("td"));
                WebElement cellLink = tdList.get(5);
                WebElement delete = cellLink.findElement(By.tagName("span"));
                Actions action = new Actions(driver);
                action.moveToElement(delete).click().build().perform();
                Thread.sleep(3000);
                driver.switchTo().alert().accept();
                log.info("Item delete correctly");
                return;
            }
        }
        Thread.sleep(3000);
    }
}

