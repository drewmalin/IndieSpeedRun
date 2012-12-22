package com.lezend.components;

import com.lezend.core.GameObject;
import com.lezend.core.GameWorld;
import com.lezend.utils.xml.Animation;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 1:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PhysicsComponent {
    public abstract void update(GameObject gameObject, GameWorld gameWorld);

    public abstract Vector2f getPosition();
    public abstract void setPosition(float x, float y);
    public abstract void setPosition(float[] array);

    public abstract float getMass();
    public abstract void setMass(float m);

    void setStageChangePosition(float x, float y);

}
