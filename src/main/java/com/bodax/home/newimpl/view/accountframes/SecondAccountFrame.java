package com.bodax.home.newimpl.view.accountframes;

import com.bodax.home.newimpl.view.AccountFrame;
import javafx.scene.control.Label;
import com.bodax.home.newimpl.controller.MainController;
import com.bodax.home.newimpl.util.Property;

public class SecondAccountFrame implements AccountFrame {
    private final MainController controller;

    public SecondAccountFrame (MainController controller) {
        this.controller = controller;
    }

    @Override
    public String getLogin() {
        return Property.getLogin2();
    }

    @Override
    public String getPassword() {
        return Property.getPass2();
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
