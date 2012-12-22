package com.lezend.managers;

import com.lezend.Globals;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 1:43 AM
 * To change this template use File | Settings | File Templates.
 */
public enum GraphicsManager {
    MANAGER;

    private int windowWidth     = Globals.DEFAULT_WIDTH;
    private int windowHeight    = Globals.DEFAULT_HEIGHT;
    private int windowX         = Globals.DEFAULT_X;
    private int windowY         = Globals.DEFAULT_Y;
    private float nearZ         = Globals.DEFAULT_NEAR;
    private float farZ          = Globals.DEFAULT_FAR;
    private boolean fullScreen  = false;

    public void init() {
        createDisplay();
        createGraphics();
    }

    private void createDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(windowWidth, windowHeight));
            if (fullScreen) {
                for (DisplayMode dm : Display.getAvailableDisplayModes()) {
                    if (dm.toString().contains(windowWidth + " x " + windowHeight + " x " + 32)) {
                        Display.setDisplayMode(dm);
                        Display.setFullscreen(true);
                        break;
                    }
                }
            }
            Display.create();

        } catch (LWJGLException e) {
            System.err.println("Error: Failed to create display.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void createGraphics() {
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glMatrixMode(GL11.GL_PROJECTION);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glLoadIdentity();
        GL11.glOrtho(0, windowWidth, windowHeight, 0, nearZ, farZ);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glShadeModel(GL11.GL_SMOOTH);
    }

    public void reset() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
    }

    public void drawScreen() {
        Display.update();
        Display.sync(60);
    }

    public boolean isCloseRequested() {
        return Display.isCloseRequested();
    }

    public void destroy() {
        Display.destroy();
    }

    //--- Getters/Setters ---//

    public void setWindowX(int x)           { this.windowX = x; }
    public void setWindowY(int y)           { this.windowY = y; }
    public void setWindowHeight(int height) { this.windowHeight = height; }
    public void setWindowWidth(int width)   { this.windowWidth = width; }
    public void setNearZ(float nearZ)       { this.nearZ = nearZ; }
    public void setFarZ(float farZ)         { this.farZ = farZ; }
    public void setFullScreen(boolean fullScreen) { this.fullScreen = fullScreen; }

    public int getWindowX()         { return this.windowX; }
    public int getWindowY()         { return this.windowY; }
    public int getWindowHeight()    { return this.windowHeight; }
    public int getWindowWidth()     { return this.windowWidth; }
    public float getNearZ()         { return this.nearZ; }
    public float getFarZ()          { return this.farZ; }
    public boolean getFullScreen()  { return this.fullScreen; }
}
