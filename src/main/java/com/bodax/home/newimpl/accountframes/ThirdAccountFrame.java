package com.bodax.home.newimpl.accountframes;

import com.bodax.home.newimpl.AccountFrame;
import javafx.scene.control.Label;
import sample.MainController;
import sample.Property;

public class ThirdAccountFrame implements AccountFrame {
    private final MainController controller;
    private final Property properties;

    public ThirdAccountFrame(MainController controller) {
        this.controller = controller;
        this.properties = new Property();
    }

    @Override
    public String getLogin() {
        return properties.getLogin3();
    }

    @Override
    public String getPassword() {
        return properties.getPass3();
    }

    @Override
    public String getComboBoxComment() {
        return controller.getComboBoxComment3().getValue();
    }

    @Override
    public String getDistrict() {
        return controller.getDistrict3();
    }

    @Override
    public float getRate() {
        return controller.getRate3();
    }

    @Override
    public String getCurrency() {
        return controller.getCurrency3();
    }

    @Override
    public String getValue() {
        return controller.getValue3();
    }

    @Override
    public String getWant() {
        return controller.getWant3();
    }

    @Override
    public MainController getController() {
        return this.controller;
    }

    @Override
    public Label getStatusLabel() {
        return controller.getStatusLabel3();
    }
}
