package com.lezend.core;

import com.lezend.components.GraphicsComponent;
import com.lezend.components.InputComponent;
import com.lezend.components.PhysicsComponent;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 1:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameObject {
    private GraphicsComponent graphicsComponent;
    private PhysicsComponent physicsComponent;
    private InputComponent inputComponent;

    public float x = 50f;
    public float y = 50f;

    public GameObject(GraphicsComponent gC, PhysicsComponent pC, InputComponent iC) {
        graphicsComponent = gC;
        physicsComponent = pC;
        inputComponent = iC;
    }

    public void update(GameWorld gameWorld) {
        physicsComponent.update(this, gameWorld);
        graphicsComponent.update(this, gameWorld);
        inputComponent.update(this, gameWorld);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
