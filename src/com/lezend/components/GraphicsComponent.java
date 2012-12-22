package com.lezend.components;

import com.lezend.core.GameObject;
import com.lezend.core.GameWorld;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 1:42 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GraphicsComponent {
    public abstract void update(GameObject gameObject, GameWorld gameWorld);
}
