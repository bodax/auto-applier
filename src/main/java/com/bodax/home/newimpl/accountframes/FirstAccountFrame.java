package com.bodax.home.newimpl.accountframes;

import com.bodax.home.newimpl.AccountFrame;
import javafx.scene.control.Label;
import sample.MainController;
import sample.Property;

public class FirstAccountFrame implements AccountFrame {

    private final MainController controller;
    private final Property properties;

    public FirstAccountFrame(MainController controller) {
        this.controller = controller;
        this.properties = new Property();
    }

    @Override
    public String getLogin() {
        return properties.getLogin1();
    }

    @Override
    public String getPassword() {
        return properties.getPass1();
    }

    @Override
    public String getComboBoxComment() {
        return controller.getComboBoxComment1().getValue();
    }

    @Override
    public String getDistrict() {
        return controller.getDistrict1();
    }

    @Override
    public float getRate() {
        return controller.getRate1();
    }

    @Override
    public String getCurrency() {
        return controller.getCurrency1();
    }

    @Override
    public String getValue() {
        return controller.getValue1();
    }

    @Override
    public String getWant() {
        return controller.getWant1();
    }

    @Override
    public MainController getController() {
        return this.controller;
    }

    @Override
    public Label getStatusLabel() {
        return controller.getStatusLabel1();
    }
}
