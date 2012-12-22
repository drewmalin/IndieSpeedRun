package com.lezend.core;

import com.lezend.components.GraphicsComponent;
import com.lezend.components.InputComponent;
import com.lezend.components.PhysicsComponent;
import com.lezend.managers.ResourceManager;
import com.lezend.utils.xml.Animation;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;

import java.util.HashMap;

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

    private String animationFile = null;
    private String scriptFile = null;
    private String loadFile = null;

    public HashMap<String, Animation> animations;

    public GameObject(GraphicsComponent gC, PhysicsComponent pC, InputComponent iC, String loadFile) {
        graphicsComponent = gC;
        physicsComponent = pC;
        inputComponent = iC;

        animations = new HashMap<String, Animation>();

        //Dynamically get the animation file
        ResourceManager.MANAGER.loadObject(this, loadFile);
        ResourceManager.MANAGER.loadAnimations(this, "res/entities/PlayerAnimations.xml");
    }

    public void update(GameWorld gameWorld) {
        physicsComponent.update(this, gameWorld);
        graphicsComponent.update(this, gameWorld);
        inputComponent.update(this, gameWorld);
    }

    public void stageChangePosition(float x, float y) {
        this.physicsComponent.setStageChangePosition(x, y);
    }

    public Texture nextFrame(int id, String animation) {
        return animations.get(animation).getNextFrame();
    }

    public void loadNextAnimationFrame(String animationKey) {
        this.graphicsComponent.setFrame(this.animations.get(animationKey).getNextFrame());
    }

    /*
    public Texture setFrame(int id, String frame) {
        return textureStore.get(id).cycle.get(frame).get(0);
    }

    public String lastAnimation(int id) {
        return textureStore.get(id).lastAnimation;
    }
    */

    // Getters, setters
    public void setPosition(float[] array) { this.physicsComponent.setPosition(array); }
    public void setPosition(int x, int y) { this.physicsComponent.setPosition(x, y); }
    public Vector2f getPosition() { return this.physicsComponent.getPosition(); }

    public void setMass(float mass) { this.physicsComponent.setMass(mass); }
    public float getMass() { return this.physicsComponent.getMass(); }

    public void setWidth(int width) { this.graphicsComponent.setWidth(width); }
    public float getWidth() { return this.graphicsComponent.getWidth(); }

    public void setHeight(int height) { this.graphicsComponent.setHeight(height); }
    public float getHeight() { return this.graphicsComponent.getHeight(); }

    public void setLightRadius(float lightRadius) { this.graphicsComponent.setLightRadius(lightRadius); }
    public float getLightRadius() {return this.graphicsComponent.getLightRadius(); }

    public void setAnimationFile(String file) { animationFile = file; }
    public String getAnimationFile() { return animationFile; }

    public void setScriptFile(String file) { scriptFile = file; }
    public String getScriptFile() { return scriptFile; }

    public void setLoadFile(String file) { loadFile = file; }
    public String getLoadFile() { return loadFile; }
}
