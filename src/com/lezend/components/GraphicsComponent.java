package com.lezend.components;

import com.lezend.core.GameObject;
import com.lezend.core.GameWorld;
import org.newdawn.slick.opengl.Texture;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 1:42 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GraphicsComponent {
    public abstract void update(GameObject gameObject, GameWorld gameWorld);

    public abstract float getWidth();
    public abstract void setWidth(int width);

    public abstract float getHeight();
    public abstract void setHeight(int height);

    public abstract float getLightRadius();
    public abstract void setLightRadius(float radius);

    public abstract void setFrame(Texture t);
}
