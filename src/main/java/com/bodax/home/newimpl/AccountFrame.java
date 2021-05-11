package com.bodax.home.newimpl;

import javafx.scene.control.Label;

public interface AccountFrame {

    String getLogin();

    String getPassword();

    String getComboBoxComment();

    String getDistrict();

    float getRate();

    String getCurrency();

    String getValue();

    String getWant();

    MainController getController ();

    Label getStatusLabel ();
}
