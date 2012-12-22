package com.lezend.player;

import com.lezend.components.GraphicsComponent;
import com.lezend.core.GameObject;
import com.lezend.core.GameWorld;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 2:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerGraphicsComponent implements GraphicsComponent {

    //Temporary: for testing purposes only
    private int tempWidth = 10;
    private int tempHeight = 10;

    public PlayerGraphicsComponent() {
        System.out.println("PlayerPhysicsComponent");
        // load saved data (position, mass, etc.)
    }

    @Override
    public void update(GameObject gameObject, GameWorld gameWorld) {
        //Draw placeholder square

        GL11.glPushMatrix();
        GL11.glColor4f(1f, 1f, 1f, 1f);
        GL11.glTranslatef(gameObject.x, gameObject.y, 0f);
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(0, 0);
            GL11.glVertex2f(tempWidth, 0);
            GL11.glVertex2f(tempWidth, tempHeight);
            GL11.glVertex2f(0, tempHeight);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
}
