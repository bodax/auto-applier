package com.bodax.home.newimpl.accountframes;

import com.bodax.home.newimpl.AccountFrame;
import javafx.scene.control.Label;
import sample.MainController;
import sample.Property;

public class SecondAccountFrame implements AccountFrame {
    private final MainController controller;
    private final Property properties;

    public SecondAccountFrame (MainController controller) {
        this.controller = controller;
        this.properties = new Property();
    }

    @Override
    public String getLogin() {
        return properties.getLogin2();
    }

    @Override
    public String getPassword() {
        return properties.getPass2();
    }

    @Override
    public String getComboBoxComment() {
        return controller.getComboBoxComment2().getValue();
    }

    @Override
    public String getDistrict() {
        return controller.getDistrict2();
    }

    @Override
    public float getRate() {
        return controller.getRate2();
    }

    @Override
    public String getCurrency() {
        return controller.getCurrency2();
    }

    @Override
    public String getValue() {
        return controller.getValue2();
    }

    @Override
    public String getWant() {
        return controller.getWant2();
    }

    @Override
    public MainController getController() {
        return this.controller;
    }

    @Override
    public Label getStatusLabel() {
        return controller.getStatusLabel2();
    }
}
