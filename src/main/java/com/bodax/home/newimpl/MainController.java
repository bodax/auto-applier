package com.bodax.home.newimpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    private static final String SALE = "продать";
    private static final String BUY = "купить";
    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String RUB = "RUB";

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

    Property property = new Property();

    @FXML
    private void initialize() {
        comboBoxSaleOrBuy1.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy1.setValue(SALE);

        comboBoxCurrency1.setItems(getCurrencyList());
        comboBoxCurrency1.setValue(USD);
        setLabelLogin1(labelLogin1);

        comboBoxComment1.setItems(getComment());
        comboBoxComment2.setItems(getComment());
        comboBoxComment3.setItems(getComment());
        comboBoxComment4.setItems(getComment());
        comboBoxComment5.setItems(getComment());

        comboBoxSaleOrBuy2.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy2.setValue(SALE);
        comboBoxCurrency2.setItems(getCurrencyList());
        comboBoxCurrency2.setValue(USD);
        setLabelLogin2(labelLogin2);

        comboBoxSaleOrBuy3.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy3.setValue(SALE);
        comboBoxCurrency3.setItems(getCurrencyList());
        comboBoxCurrency3.setValue(USD);
        setLabelLogin3(labelLogin3);

        comboBoxSaleOrBuy4.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy4.setValue(SALE);
        comboBoxCurrency4.setItems(getCurrencyList());
        comboBoxCurrency4.setValue(USD);
        setLabelLogin4(labelLogin4);

        comboBoxSaleOrBuy5.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy5.setValue(SALE);
        comboBoxCurrency5.setItems(getCurrencyList());
        comboBoxCurrency5.setValue(USD);
        setLabelLogin5(labelLogin5);
    }

    private ObservableList<String> getSaleOrBuyList() {
        return FXCollections.observableArrayList(BUY, SALE);
    }

    private ObservableList<String> getCurrencyList() {
        return FXCollections.observableArrayList(USD, EUR, RUB);
    }

    private ObservableList<String> getComment() {
        return FXCollections.observableArrayList(property.getComment1(),
                property.getComment2(),
                property.getComment3(),
                property.getComment4(),
                property.getComment5());
    }

    public void setLabelLogin1(final Label labelLogin1) {
        this.labelLogin1 = labelLogin1;
        labelLogin1.setText(property.getLogin1());
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

    AccountFrameFactory factory = new AccountFrameFactory(this);
    private AccountThread tr1;

    public void login1StartBtnClick() {
        tr1 = new AccountThread(factory.getAccountFrameByFrameNumber(FrameNumber.FIRST));
        Thread thread = new Thread(tr1, FrameNumber.FIRST.name());
        thread.start();
    }

    public void login1StopBtnClick() throws InterruptedException {
        tr1.deleteByUser();
        tr1.closeDriver();
    }

    // Thread 2
    private AccountThread tr2;

    public void login2StartBtnClick() {
        tr2 = new AccountThread(factory.getAccountFrameByFrameNumber(FrameNumber.SECOND));
        Thread thread = new Thread(tr2, FrameNumber.SECOND.name());
        thread.start();
    }

    public void login2StopBtnClick() throws InterruptedException {
        tr2.deleteByUser();
        tr2.closeDriver();
    }

    public void setLabelLogin2(final Label labelLogin2) {
        this.labelLogin2 = labelLogin2;
        labelLogin2.setText(property.getLogin2());
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

    public void setLabelLogin3(final Label labelLogin3) {
        this.labelLogin3 = labelLogin3;
        labelLogin3.setText(property.getLogin3());
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


    private AccountThread tr3;

    public void login3StartBtnClick() {
        tr3 = new AccountThread(factory.getAccountFrameByFrameNumber(FrameNumber.THIRD));
        Thread thread = new Thread(tr3, FrameNumber.THIRD.name());
        thread.start();
    }

    public void login3StopBtnClick() throws InterruptedException {
        tr3.deleteByUser();
        tr3.closeDriver();
    }

    //Thread 4
    public String getWant4() {
        return comboBoxSaleOrBuy4.getSelectionModel().getSelectedItem();
    }

    public void setLabelLogin4(final Label labelLogin4) {
        this.labelLogin4 = labelLogin4;
        labelLogin4.setText(property.getLogin4());
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


    private AccountThread tr4;

    public void login4StartBtnClick() {
        tr4 = new AccountThread(factory.getAccountFrameByFrameNumber(FrameNumber.FOURTH));
        Thread thread = new Thread(tr4, FrameNumber.FOURTH.name());
        thread.start();
    }

    public void login4StopBtnClick() throws InterruptedException {
        tr4.deleteByUser();
        tr4.closeDriver();
    }

    //Thread 5
    public String getWant5() {
        return comboBoxSaleOrBuy5.getSelectionModel().getSelectedItem();
    }

    public void setLabelLogin5(final Label labelLogin5) {
        this.labelLogin5 = labelLogin5;
        labelLogin5.setText(property.getLogin5());
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

    private AccountThread tr5;

    public void login5StartBtnClick() {
        tr5 = new AccountThread(factory.getAccountFrameByFrameNumber(FrameNumber.FIFTH));
        Thread thread = new Thread(tr5, FrameNumber.FIFTH.name());
        thread.start();
    }

    public void login5StopBtnClick() throws InterruptedException {
        tr5.deleteByUser();
        tr5.closeDriver();
    }
}
