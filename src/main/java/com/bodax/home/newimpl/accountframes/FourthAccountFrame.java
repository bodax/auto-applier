package com.bodax.home.newimpl.accountframes;

import com.bodax.home.newimpl.AccountFrame;
import javafx.scene.control.Label;
import sample.MainController;
import sample.Property;

public class FourthAccountFrame implements AccountFrame {
    private final MainController controller;
    private final Property properties;

    public FourthAccountFrame(MainController controller) {
        this.controller = controller;
        this.properties = new Property();
    }

    @Override
    public String getLogin() {
        return properties.getLogin4();
    }

    @Override
    public String getPassword() {
        return properties.getPass4();
    }

    @Override
    public String getComboBoxComment() {
        return controller.getComboBoxComment4().getValue();
    }

    @Override
    public String getDistrict() {
        return controller.getDistrict4();
    }

    @Override
    public float getRate() {
        return controller.getRate4();
    }

    @Override
    public String getCurrency() {
        return controller.getCurrency4();
    }

    @Override
    public String getValue() {
        return controller.getValue4();
    }

    @Override
    public String getWant() {
        return controller.getWant4();
    }

    @Override
    public MainController getController() {
        return this.controller;
    }

    @Override
    public Label getStatusLabel() {
        return controller.getStatusLabel4();
    }
}
