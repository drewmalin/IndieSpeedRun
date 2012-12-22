package com.lezend.player;

import com.lezend.components.PhysicsComponent;
import com.lezend.core.GameObject;
import com.lezend.core.GameWorld;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 2:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerPhysicsComponent implements PhysicsComponent {

    private final Vector2f position;
    private final Vector2f delta;

    private float mass;

    public PlayerPhysicsComponent() {
        position = new Vector2f(0, 0);
        delta = new Vector2f(0, 0);
        mass     = 1f;
    }

    @Override
    public void update(GameObject gameObject, GameWorld gameWorld) {
        // Check for collision

        if (((position.x + delta.x) < 100) && (position.x + delta.x) > 0)
            position.x += delta.x;

        if (((position.y + delta.y) < 100) && (position.y + delta.y) > 0)
            position.y += delta.y;

        reset();
    }

    public void reset() {
        delta.set(0, 0);
    }

    public void setStageChangePosition(float x, float y) {
        delta.set(x, y);
    }

    // Getters, setters

    @Override
    public void setPosition(float x, float y) { position.set(x, y);}

    @Override
    public void setPosition(float[] array) {
        assert array.length == 2;
        position.set(array[0], array[1]);
    }

    @Override
    public Vector2f getPosition() {return position; }

    @Override
    public void setMass(float m) { mass = m; }

    @Override
    public float getMass() { return mass; }
}
