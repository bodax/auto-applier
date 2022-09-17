package com.bodax.home.newimpl.accountframes;

import com.bodax.home.newimpl.AccountFrame;
import javafx.scene.control.Label;
import com.bodax.home.newimpl.MainController;
import com.bodax.home.newimpl.Property;

public class FirstAccountFrame implements AccountFrame {

    private final MainController controller;

    public FirstAccountFrame(MainController controller) {
        this.controller = controller;
    }

    @Override
    public String getLogin() {
        return Property.getLogin1();
    }

    @Override
    public String getPassword() {
        return Property.getPass1();
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
