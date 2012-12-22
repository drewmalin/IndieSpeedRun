package com.lezend.player;

import com.lezend.components.PhysicsComponent;
import com.lezend.core.GameObject;
import com.lezend.core.GameWorld;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 2:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerPhysicsComponent implements PhysicsComponent {

    public PlayerPhysicsComponent() {
        System.out.println("PlayerPhysicsComponent");
        // load saved data (position, mass, etc.)
    }

    @Override
    public void update(GameObject gameObject, GameWorld gameWorld) {

    }
}
