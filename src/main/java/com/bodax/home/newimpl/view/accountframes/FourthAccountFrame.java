package com.bodax.home.newimpl.view.accountframes;

import com.bodax.home.newimpl.view.AccountFrame;
import javafx.scene.control.Label;
import com.bodax.home.newimpl.controller.MainController;
import com.bodax.home.newimpl.util.Property;

public class FourthAccountFrame implements AccountFrame {
    private final MainController controller;

    public FourthAccountFrame(MainController controller) {
        this.controller = controller;
    }

    @Override
    public String getLogin() {
        return Property.getLogin4();
    }

    @Override
    public String getPassword() {
        return Property.getPass4();
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
