package com.bodax.home.newimpl.accountframes;

import com.bodax.home.newimpl.AccountFrame;
import javafx.scene.control.Label;
import sample.MainController;
import sample.Property;

public class FifthAccountFrame implements AccountFrame {
    private final MainController controller;
    private final Property properties;

    public FifthAccountFrame(MainController controller) {
        this.controller = controller;
        this.properties = new Property();
    }

    @Override
    public String getLogin() {
        return properties.getLogin5();
    }

    @Override
    public String getPassword() {
        return properties.getPass5();
    }

    @Override
    public String getComboBoxComment() {
        return controller.getComboBoxComment5().getValue();
    }

    @Override
    public String getDistrict() {
        return controller.getDistrict5();
    }

    @Override
    public float getRate() {
        return controller.getRate5();
    }

    @Override
    public String getCurrency() {
        return controller.getCurrency5();
    }

    @Override
    public String getValue() {
        return controller.getValue5();
    }

    @Override
    public String getWant() {
        return controller.getWant5();
    }

    @Override
    public MainController getController() {
        return controller;
    }

    @Override
    public Label getStatusLabel() {
        return controller.getStatusLabel5();
    }
}
