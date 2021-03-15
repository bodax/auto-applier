package sample;

import com.bodax.home.threads.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {

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
    private void initialize() throws IOException {
        comboBoxSaleOrBuy1.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy1.setValue("продать");

        comboBoxCurrency1.setItems(getCurrencyList());
        comboBoxCurrency1.setValue("USD");
        setLabelLogin1(labelLogin1);

        comboBoxComment1.setItems(getComment());
        comboBoxComment2.setItems(getComment());
        comboBoxComment3.setItems(getComment());
        comboBoxComment4.setItems(getComment());
        comboBoxComment5.setItems(getComment());

        comboBoxSaleOrBuy2.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy2.setValue("продать");
        comboBoxCurrency2.setItems(getCurrencyList());
        comboBoxCurrency2.setValue("USD");
        setLabelLogin2(labelLogin2);

        comboBoxSaleOrBuy3.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy3.setValue("продать");
        comboBoxCurrency3.setItems(getCurrencyList());
        comboBoxCurrency3.setValue("USD");
        setLabelLogin3(labelLogin3);

        comboBoxSaleOrBuy4.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy4.setValue("продать");
        comboBoxCurrency4.setItems(getCurrencyList());
        comboBoxCurrency4.setValue("USD");
        setLabelLogin4(labelLogin4);

        comboBoxSaleOrBuy5.setItems(getSaleOrBuyList());
        comboBoxSaleOrBuy5.setValue("продать");
        comboBoxCurrency5.setItems(getCurrencyList());
        comboBoxCurrency5.setValue("USD");
        setLabelLogin5(labelLogin5);
    }


    private ObservableList<String> getSaleOrBuyList() {
        return FXCollections.observableArrayList("купить", "продать");
    }

    private ObservableList<String> getCurrencyList() {
        return FXCollections.observableArrayList("USD", "EUR", "RUB");
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

    private Thread1 tr1;

    public void login1StartBtnClick() throws IOException {
        tr1 = new Thread1(this);
        Thread thread1 = new Thread(tr1);
        thread1.start();
    }

    public void login1StopBtnClick() throws IOException, InterruptedException {
        tr1.deleteByUser();
        tr1.closeDriver();
    }

    //Thread 2
    private Thread2 tr2;

    public void login2StartBtnClick() {
        tr2 = new Thread2(this);
        Thread thread2 = new Thread(tr2);
        thread2.start();
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


    private Thread3 tr3;

    public void login3StartBtnClick() throws IOException {
        tr3 = new Thread3(this);
        Thread thread3 = new Thread(tr3);
        thread3.start();
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


    private Thread4 tr4;

    public void login4StartBtnClick() throws IOException {
        tr4 = new Thread4(this);
        Thread thread4 = new Thread(tr4);
        thread4.start();
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


    private Thread5 tr5;

    public void login5StartBtnClick() throws IOException {
        tr5 = new Thread5(this);
        Thread thread5 = new Thread(tr5);
        thread5.start();
    }

    public void login5StopBtnClick() throws InterruptedException {
        tr5.deleteByUser();
        tr5.closeDriver();
    }
}
