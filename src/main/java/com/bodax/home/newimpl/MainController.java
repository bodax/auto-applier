package com.bodax.home.newimpl;

import com.bodax.home.newimpl.accountframes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainController {

    private static final String SALE = "продать";
    private static final String BUY = "купить";
    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String PLN = "PLN";

    @FXML
    Label labelLogin1;
    @FXML
    Label statusLabel1;
    @FXML
    private TextField valueField1;
    @FXML
    private TextField rateField1;
    @FXML
    private TextField districtField1;
    @FXML
    public ComboBox<String> comboBoxSaleOrBuy1;
    @FXML
    public ComboBox<String> comboBoxCurrency1;
    @FXML
    public ComboBox<String> comboBoxComment1;
    @FXML
    Label labelLogin2;
    @FXML
    Label statusLabel2;
    @FXML
    private TextField valueField2;
    @FXML
    private TextField rateField2;
    @FXML
    private TextField districtField2;
    @FXML
    public ComboBox<String> comboBoxSaleOrBuy2;
    @FXML
    public ComboBox<String> comboBoxCurrency2;
    @FXML
    public ComboBox<String> comboBoxComment2;
    @FXML
    Label labelLogin3;
    @FXML
    Label statusLabel3;
    @FXML
    private TextField valueField3;
    @FXML
    private TextField rateField3;
    @FXML
    private TextField districtField3;
    @FXML
    public ComboBox<String> comboBoxSaleOrBuy3;
    @FXML
    public ComboBox<String> comboBoxCurrency3;
    @FXML
    public ComboBox<String> comboBoxComment3;
    @FXML
    Label labelLogin4;
    @FXML
    Label statusLabel4;
    @FXML
    private TextField valueField4;
    @FXML
    private TextField rateField4;
    @FXML
    private TextField districtField4;
    @FXML
    public ComboBox<String> comboBoxSaleOrBuy4;
    @FXML
    public ComboBox<String> comboBoxCurrency4;
    @FXML
    public ComboBox<String> comboBoxComment4;
    @FXML
    Label labelLogin5;
    @FXML
    Label statusLabel5;
    @FXML
    private TextField valueField5;
    @FXML
    private TextField rateField5;
    @FXML
    private TextField districtField5;
    @FXML
    public ComboBox<String> comboBoxSaleOrBuy5;
    @FXML
    public ComboBox<String> comboBoxCurrency5;
    @FXML
    public ComboBox<String> comboBoxComment5;

    @FXML
    private void initialize() {
        comboBoxSaleOrBuy1.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy1.setValue(SALE);
        comboBoxCurrency1.setItems(getCurrencyList());
        comboBoxCurrency1.setValue(USD);
        labelLogin1.setText(Property.getLogin1());

        comboBoxComment1.setItems(getComment());
        comboBoxComment2.setItems(getComment());
        comboBoxComment3.setItems(getComment());
        comboBoxComment4.setItems(getComment());
        comboBoxComment5.setItems(getComment());

        comboBoxSaleOrBuy2.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy2.setValue(SALE);
        comboBoxCurrency2.setItems(getCurrencyList());
        comboBoxCurrency2.setValue(USD);
        labelLogin2.setText(Property.getLogin2());

        comboBoxSaleOrBuy3.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy3.setValue(SALE);
        comboBoxCurrency3.setItems(getCurrencyList());
        comboBoxCurrency3.setValue(USD);
        labelLogin3.setText(Property.getLogin3());

        comboBoxSaleOrBuy4.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy4.setValue(SALE);
        comboBoxCurrency4.setItems(getCurrencyList());
        comboBoxCurrency4.setValue(USD);
        labelLogin4.setText(Property.getLogin4());

        comboBoxSaleOrBuy5.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy5.setValue(SALE);
        comboBoxCurrency5.setItems(getCurrencyList());
        comboBoxCurrency5.setValue(USD);
        labelLogin5.setText(Property.getLogin5());
    }

    private ObservableList<String> getSaleOrBuyList() {
        return FXCollections.observableArrayList(BUY, SALE);
    }

    private ObservableList<String> getCurrencyList() {
        return FXCollections.observableArrayList(USD, EUR, PLN);
    }

    private ObservableList<String> getComment() {
        return FXCollections.observableArrayList(Property.getComment1(),
                Property.getComment2(),
                Property.getComment3(),
                Property.getComment4(),
                Property.getComment5());
    }

    public Label getStatusLabel1() {
        return statusLabel1;
    }

    public String getWant1() {
        return comboBoxSaleOrBuy1.getSelectionModel().getSelectedItem();
    }

    public String getCurrency1() {
        return comboBoxCurrency1.getSelectionModel().getSelectedItem();
    }

    public String getValue1() {
        return valueField1.getText();
    }

    public ComboBox<String> getComboBoxComment1() {
        return comboBoxComment1;
    }

    public String getDistrict1() {
        return districtField1.getText();
    }

    public float getRate1() {
        return Float.parseFloat(rateField1.getText());
    }


    private ExecutorService es1;
    private AccountThread tr1;

    public void login1StartBtnClick() {
        es1 = Executors.newSingleThreadExecutor();
        tr1 = new AccountThread(new FirstAccountFrame(this));
        es1.execute(tr1);
    }

    public void login1StopBtnClick() {
        tr1.deleteAndClose();
        es1.shutdown();
    }

    // Thread 2
    private ExecutorService es2;
    private AccountThread tr2;

    public void login2StartBtnClick() {
        es2 = Executors.newSingleThreadExecutor();
        tr2 = new AccountThread(new SecondAccountFrame(this));
        es2.execute(tr2);
    }

    public void login2StopBtnClick() {
        tr2.deleteAndClose();
        es2.shutdown();
    }

    public Label getStatusLabel2() {
        return statusLabel2;
    }

    public String getWant2() {
        return comboBoxSaleOrBuy2.getSelectionModel().getSelectedItem();
    }

    public ComboBox<String> getComboBoxComment2() {
        return comboBoxComment2;
    }

    public String getCurrency2() {
        return comboBoxCurrency2.getSelectionModel().getSelectedItem();
    }

    public String getValue2() {
        return valueField2.getText();
    }

    public String getDistrict2() {
        return districtField2.getText();
    }

    public float getRate2() {
        return Float.parseFloat(rateField2.getText());
    }

    //Thread 3
    public String getWant3() {
        return comboBoxSaleOrBuy3.getSelectionModel().getSelectedItem();
    }

    public ComboBox<String> getComboBoxComment3() {
        return comboBoxComment3;
    }

    public Label getStatusLabel3() {
        return statusLabel3;
    }

    public String getCurrency3() {
        return comboBoxCurrency3.getSelectionModel().getSelectedItem();
    }

    public String getValue3() {
        return valueField3.getText();
    }

    public String getDistrict3() {
        return districtField3.getText();
    }

    public float getRate3() {
        return Float.parseFloat(rateField3.getText());
    }


    private ExecutorService es3;
    private AccountThread tr3;

    public void login3StartBtnClick() {
        es3 = Executors.newSingleThreadExecutor();
        tr3 = new AccountThread(new ThirdAccountFrame(this));
        es3.execute(tr3);
    }

    public void login3StopBtnClick() {
        tr3.deleteAndClose();
        es3.shutdown();
    }

    //Thread 4
    public String getWant4() {
        return comboBoxSaleOrBuy4.getSelectionModel().getSelectedItem();
    }

    public Label getStatusLabel4() {
        return statusLabel4;
    }

    public String getCurrency4() {
        return comboBoxCurrency4.getSelectionModel().getSelectedItem();
    }

    public String getValue4() {
        return valueField4.getText();
    }

    public ComboBox<String> getComboBoxComment4() {
        return comboBoxComment4;
    }

    public String getDistrict4() {
        return districtField4.getText();
    }

    public float getRate4() {
        return Float.parseFloat(rateField4.getText());
    }


    private ExecutorService es4;
    private AccountThread tr4;

    public void login4StartBtnClick() {
        es4 = Executors.newSingleThreadExecutor();
        tr4 = new AccountThread(new FourthAccountFrame(this));
        es4.execute(tr4);
    }

    public void login4StopBtnClick()  {
        tr4.deleteAndClose();
        es4.shutdown();
    }

    //Thread 5
    public String getWant5() {
        return comboBoxSaleOrBuy5.getSelectionModel().getSelectedItem();
    }

    public Label getStatusLabel5() {
        return statusLabel5;
    }

    public String getCurrency5() {
        return comboBoxCurrency5.getSelectionModel().getSelectedItem();
    }

    public String getValue5() {
        return valueField5.getText();
    }

    public String getDistrict5() {
        return districtField5.getText();
    }

    public ComboBox<String> getComboBoxComment5() {
        return comboBoxComment5;
    }

    public float getRate5() {
        return Float.parseFloat(rateField5.getText());
    }

    private ExecutorService es5;
    private AccountThread tr5;

    public void login5StartBtnClick() {
        es5 = Executors.newSingleThreadExecutor();
        tr5 = new AccountThread(new FifthAccountFrame(this));
        es5.execute(tr5);
    }

    public void login5StopBtnClick() {
        tr5.deleteAndClose();
        es5.shutdown();
    }
}
