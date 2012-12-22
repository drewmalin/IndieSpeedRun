package com.lezend.utils.xml;

import org.newdawn.slick.opengl.Texture;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Animation {

    public String key;
    public ArrayList<Texture> frames;
    public long speedNano;
    public long lastCheckNano;
    public int lastFrame;

    public Animation() {
        lastCheckNano = speedNano = lastFrame = 0;
        frames = new ArrayList<Texture>();
    }

    private void advanceFrame() {

        if (lastFrame + 1 == frames.size())
            lastFrame = 0;
        else
            lastFrame++;

        lastCheckNano = System.nanoTime();
    }

    public Texture getNextFrame() {

        if (System.nanoTime() - lastCheckNano >= speedNano)
            advanceFrame();

        return frames.get(lastFrame);

    }

}
