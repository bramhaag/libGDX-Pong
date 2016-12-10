package me.bramhaag.pong.util;

import javax.annotation.Nonnull;

/**
 * Created by Bram on 10-12-2016.
 */
public enum Message {

    PRESS_TO_CONTINUE("Press SPACE to continue");

    private String message;

    Message(@Nonnull String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
