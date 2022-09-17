package com.bodax.home.newimpl.accountframes;

import com.bodax.home.newimpl.AccountFrame;
import javafx.scene.control.Label;
import com.bodax.home.newimpl.MainController;
import com.bodax.home.newimpl.Property;

public class ThirdAccountFrame implements AccountFrame {

    private final MainController controller;

    public ThirdAccountFrame(MainController controller) {
        this.controller = controller;
    }

    @Override
    public String getLogin() {
        return Property.getLogin3();
    }

    @Override
    public String getPassword() {
        return Property.getPass3();
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
