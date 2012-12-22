package com.lezend.player;

import com.lezend.Globals;
import com.lezend.components.InputComponent;
import com.lezend.core.GameObject;
import com.lezend.core.GameWorld;
import com.lezend.managers.InputManager;
import org.lwjgl.input.Keyboard;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 2:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerInputComponent implements InputComponent {

    public PlayerInputComponent() {
        System.out.println("PlayerInputComponent");
        // load keyboard input?
    }

    @Override
    public void update(GameObject gameObject, GameWorld gameWorld) {
        /* TODO: Poll keyboard, mouse inputs-- react specifically for the player (in other extensions of the InputComponent
         * class
         */

        if (InputManager.MANAGER.keysDepressed(Keyboard.KEY_W,  Keyboard.KEY_A)) {
            gameObject.x -= Globals.DIAGONAL;
            gameObject.y -= Globals.DIAGONAL;
        }
        else if (InputManager.MANAGER.keysDepressed(Keyboard.KEY_W, Keyboard.KEY_D)) {
            gameObject.x += Globals.DIAGONAL;
            gameObject.y -= Globals.DIAGONAL;
        }
        else if (InputManager.MANAGER.keysDepressed(Keyboard.KEY_A, Keyboard.KEY_S)) {
            gameObject.x -= Globals.DIAGONAL;
            gameObject.y += Globals.DIAGONAL;
        }
        else if (InputManager.MANAGER.keysDepressed(Keyboard.KEY_S, Keyboard.KEY_D)) {
            gameObject.x += Globals.DIAGONAL;
            gameObject.y += Globals.DIAGONAL;
        }
        else if (InputManager.MANAGER.keysDepressed(Keyboard.KEY_W)) {
            gameObject.y -= 1;
        }
        else if (InputManager.MANAGER.keysDepressed(Keyboard.KEY_A)) {
            gameObject.x -= 1;
        }
        else if (InputManager.MANAGER.keysDepressed(Keyboard.KEY_S)) {
            gameObject.y += 1;
        }
        else if (InputManager.MANAGER.keysDepressed(Keyboard.KEY_D)) {
            gameObject.x += 1;
        }
    }
}
