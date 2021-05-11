package com.bodax.home.newimpl;

import com.bodax.home.newimpl.accountframes.*;

public class AccountFrameFactory {

    private final MainController controller;

    public AccountFrameFactory(MainController controller) {
        this.controller = controller;
    }

    public AccountFrame getAccountFrameByFrameNumber(FrameNumber frameNumber) {
        switch (frameNumber) {
            case FIRST:
                return new FirstAccountFrame(controller);
            case SECOND:
                return new SecondAccountFrame(controller);
            case THIRD:
                return new ThirdAccountFrame(controller);
            case FOURTH:
                return new FourthAccountFrame(controller);
            case FIFTH:
                return new FifthAccountFrame(controller);
            default:
                throw new IllegalStateException("Unexpected value: " + frameNumber);
        }
    }
}
