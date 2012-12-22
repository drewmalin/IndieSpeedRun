package com.lezend.player;

import com.lezend.components.GraphicsComponent;
import com.lezend.core.GameObject;
import com.lezend.core.GameWorld;
import com.lezend.utils.xml.Animation;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;


import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 2:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerGraphicsComponent implements GraphicsComponent {

    private int width;
    private int height;
    private float lightRadius;
    private Texture currentFrame;

    private ArrayList<Animation> animations;

    public PlayerGraphicsComponent() {}

    @Override
    public void update(GameObject gameObject, GameWorld gameWorld) {

        if (currentFrame != null) currentFrame.bind();

        GL11.glPushMatrix();
        GL11.glColor4f(1f, 1f, 1f, 1f);
        GL11.glTranslatef(gameObject.getPosition().x, gameObject.getPosition().y, 0f);
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(0, 0);

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(this.width, 0);

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(this.width, this.height);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(0, this.height);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

    @Override
    public float getWidth() { return this.width; }

    @Override
    public void setWidth(int width) { this.width = width; }

    @Override
    public float getHeight() { return this.height; }

    @Override
    public void setHeight(int height) { this.height = height; }

    @Override
    public float getLightRadius() { return this.lightRadius; }

    @Override
    public void setLightRadius(float radius) { this.lightRadius = radius; }

    @Override
    public void setFrame(Texture t) {
        currentFrame = t;
    }
}
