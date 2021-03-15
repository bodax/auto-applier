package com.bodax.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class, which help to work with different kinds of tables
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Table {
    private WebElement tableEl;
    private WebDriver driver;


    public Table(WebDriver driver, WebElement tableEl) {
        this.tableEl = tableEl;
        this.driver = driver;
    }

    /*Get a list of rows from table*/
    public List<WebElement> getRows(){
        List<WebElement> rows = driver.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

    /*Get a headers of table columns*/
    public List<WebElement> getHeaders () {
        WebElement headerRow = tableEl.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headersColumns = headerRow.findElements(By.xpath(".//td"));
        return headersColumns;
    }

    /*Get rows and column from table*/
    public List<List<WebElement>> getRowsWithColumn () {
        List<WebElement> rows = getRows();
        List <List<WebElement>> rowsWithColumn = new ArrayList<List<WebElement>>();
        for(WebElement row :rows) {
            List<WebElement> rowWithColunm = row.findElements(By.xpath("./td"));
            rowsWithColumn.add(rowWithColunm);
        }
        return rowsWithColumn;
    }

    /*Get list of rows and column by header of table*/
    public List<Map<String, WebElement>> getRowsWithColumnByHeaders () {
        List <List<WebElement>> rowsWithColumn = getRowsWithColumn();
        List<Map<String,WebElement>> rowWithColumnByHeader = new ArrayList<Map<String, WebElement>>();
        Map <String, WebElement> rowByHeader;
        List <WebElement> headersColumn = getHeaders();
        for (List<WebElement> row: rowsWithColumn) {
            rowByHeader = new HashMap <String, WebElement>();
            for (int i=0; i<headersColumn.size(); i++) {
                String header = headersColumn.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeader.put(header,cell);
            }
            rowWithColumnByHeader.add(rowByHeader);
        }
        return rowWithColumnByHeader;
    }

    /*Get information from cell of table*/
    public String getValueFromCell (int rowNumber, int cellNumber) {
        List <List<WebElement>> rowsWithColumn = getRowsWithColumn();
        WebElement cell = rowsWithColumn.get(rowNumber-1).get(cellNumber -1);
        return cell.getText();
    }

    /*Method that help to choose a needed cell in table*/
    public WebElement setPosition (int row, int cell) {
       WebElement rowSearched = getRowsWithColumn().get(row-1).get(cell-1);
        return rowSearched;
    }

}
