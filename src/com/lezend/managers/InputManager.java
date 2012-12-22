package com.lezend.managers;

import com.lezend.core.Game;
import org.lwjgl.input.Keyboard;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 1:43 AM
 * To change this template use File | Settings | File Templates.
 */
public enum InputManager {
    MANAGER;

    public void pollKeyboard(Game game) {

    }

    public void pollMouse(Game game) {

    }

    public boolean keysDepressed(int... keys) {
        boolean ret = true;
        for (int key : keys) {
            if (!Keyboard.isKeyDown(key)) ret = false;
        }
        return ret;
    }
}
