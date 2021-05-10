package com.bodax.home;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.MainController;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class FinanceUA {

    private Logger log = LoggerFactory.getLogger(FinanceUA.class);

    private WebDriver driver;
    private MainController controller;
    final String website = "https://finance.i.ua/market/kiev/?";
   /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample
   .fxml"));
   Controller controller = (Controller) fxmlLoader.getController();*/

    public FinanceUA(WebDriver driver, MainController controller) {
        this.driver = driver;
        this.controller = controller;
    }

    public void loadPage() {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(website);
        log.info(website + "was loaded");

    }
    //li[1]//a[1]

    public void clickEnterToAccount() throws InterruptedException {
        WebElement enterLink = driver.findElement(By.xpath("//a[contains(text(),'Вход')]"));
        enterLink.click();
        Thread.sleep(3000);
        System.out.println("OK - Clicked enter to account correctly");
    }

    public void setCredentials(String login, String password) throws IOException, InterruptedException {
        WebElement loginField = driver.findElement(By.xpath("//input[@name='login']"));
        loginField.sendKeys(login);
        WebElement passField = driver.findElement(By.xpath("//input[@name='pass']"));
        passField.sendKeys(password);
      /*  WebElement checkBox = driver.findElement(By.xpath("//*[@id" +
            "=\"FloatLogin\"]/div/form/div[3]/label/input"));
        checkBox.click();*/
        WebElement enterBtn = driver.findElement(By.xpath("//div[@class='form_item form_item-submit']//input"));
        enterBtn.submit();
        Thread.sleep(3000);
        System.out.println("OK - Set account credentials correctly");
    }

    public void addPropose() throws InterruptedException {
        driver.get(website);
        Thread.sleep(3000);
        WebElement addProposeBtn = driver.findElement(By.xpath("//span[contains(text(),'добавить объявление')]"));
        addProposeBtn.click();
        Thread.sleep(3000);
        System.out.println("OK - Click to add propose correctly");
    }

    public void setSaleOrBuy(String saleOrBuy) throws InterruptedException {
        WebElement setBuyOrSell = driver.findElement(By.xpath("//select[@id=\"market_record_record_type\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(setBuyOrSell).click().build().perform();
        //setBuyOrSell.click();
        if (saleOrBuy.equalsIgnoreCase("продать")) {
            WebElement saleField = driver.findElement(By.xpath("//select[@id=\"market_record_record_type\"]//option[2]"));
            saleField.click();
        } else if (saleOrBuy.equalsIgnoreCase("купить")) {
            WebElement buyField = driver.findElement(By.xpath("//select[@id=\"market_record_record_type\"]//option[1]"));
            buyField.click();
        }
        Thread.sleep(3000);
        System.out.println("OK - Set sale or buy correctly");
    }

    public void setValue(String value) throws InterruptedException {
        WebElement setValue = driver.findElement(By.xpath("//input[@id='market_record_amount']"));
        setValue.sendKeys(value);
        Thread.sleep(2000);
        System.out.println("OK - Set value correctly");
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
        System.out.println("OK - Set currency correctly");
    }

    public void setRate(String rate) throws InterruptedException {
        WebElement setRate = driver.findElement(By.xpath("//input[@id='market_record_ratio']"));
        setRate.sendKeys(rate);
        Thread.sleep(2000);
        System.out.println("OK - Set rate correctly");
    }

    public void setCity() throws InterruptedException {
        WebElement setCityField = driver.findElement(By.xpath("//select[@id='market_record_location_id']"));
        Actions actions = new Actions(driver);
        WebElement setCity = driver.findElement(By.xpath("//select[@id='market_record_location_id']/child::option[217]"));
        Select select = new Select(setCityField);
        select.selectByVisibleText("Киев");
        //  setCity.click();
        //  actions.moveToElement(setCityField).click(setCityField)
        //  .moveToElement(setCity).click(setCity).build().perform();
        Thread.sleep(1000);
        //  Thread.sleep(2000);
        System.out.println("OK - Set City correctly");
    }

    public void setDistrict(String district) throws InterruptedException {
        WebElement setDistrict = driver.findElement(By.xpath("//input[@id='market_record_district']"));
        setDistrict.sendKeys(district);
        Thread.sleep(2000);
        System.out.println("OK - Set district correctly");
    }

    public void setComment(String comment) throws InterruptedException {
        WebElement actualTime = driver.findElement(By.xpath("//input[@id='market_record_comment']"));
        actualTime.sendKeys(comment);
        Thread.sleep(2000);
        System.out.println("OK - Set comment correctly");
    }

    public void setActualTime() throws InterruptedException {
        WebElement actualTimeDropDown = driver.findElement(By.xpath("//select[@id='market_record_valid_until']"));
        Select select = new Select(actualTimeDropDown);
        select.selectByVisibleText("23:00");
        Thread.sleep(2000);
        System.out.println("OK - Set actual correctly");
    }

    public void savePropose() throws InterruptedException {
        WebElement saveBtn = driver.findElement(By.xpath("//input[@name='commit']"));
        saveBtn.submit();
        Thread.sleep(2000);
        System.out.println("OK - Add propose correctly");
    }

    public void deleteItem(String rate) throws InterruptedException {
        WebElement userApplications = driver.findElement(By.xpath("//div[@class='data_container data-user']/table/tbody"));


        WebElement delete = driver.findElement(By.xpath(String.format(
            "//div[contains(@class,'data-user')]//tbody[1]//tr[@data-ratio='%s']/descendant::span[@class='icon i_delitem']", rate)));
        ////div[contains(@class,'data_container data-user')
        // ]//tbody[1]//tr[@data-amount='%s' and contains(@data-ratio, '%s')
        // ]/descendant::span[@class= 'icon i_delitem']", rate, value)
        // /descendant::span[@class= 'icon i_delitem']
        if (delete.isDisplayed()) {
            System.out.println("Item chosen correctly");
            delete.click(); ////div[@class='data_container
            // data-user']//tbody[1]//tr[1] @data-amount='%s' and contains
            // (@data-ratio, '%s')
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Item delete correctly");
        }
    }

    public void deleteItemTest(String rate) throws InterruptedException {
        WebElement table = driver.findElement(By.xpath("//div[@class='data_container data-user']/table/tbody"));
      //  WebElement table = driver.findElement(By.xpath("//div[contains (@class, 'data-user']/table[contains(@class, 'table']"));
   //     WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> trList = table.findElements(By.tagName("tr"));
        for (WebElement tr : trList) {
            if (tr.getText().contains(rate)) {
                List<WebElement> tdList = tr.findElements(By.tagName("td"));
                WebElement cellLink = tdList.get(5);
                WebElement delete = cellLink.findElement(By.tagName("span"));
                Actions action = new Actions(driver);
                action.moveToElement(delete).click().build().perform();
               // delete.click();
                Thread.sleep(3000);
                driver.switchTo().alert().accept();
                System.out.println("Item delete correctly");
                return;
            }
        }
        Thread.sleep(3000);
    }
}

