package com.bodax.home.newimpl.accountframes;

import com.bodax.home.newimpl.AccountFrame;
import javafx.scene.control.Label;
import com.bodax.home.newimpl.MainController;
import com.bodax.home.newimpl.Property;

public class FifthAccountFrame implements AccountFrame {
    private final MainController controller;


    public FifthAccountFrame(MainController controller) {
        this.controller = controller;
    }

    @Override
    public String getLogin() {
        return Property.getLogin5();
    }

    @Override
    public String getPassword() {
        return Property.getPass5();
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
