package com.lezend.managers;

import com.lezend.core.GameObject;
import com.lezend.utils.xml.Animation;
import com.lezend.utils.xml.Node;
import com.lezend.utils.xml.XMLParser;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 9:09 AM
 * To change this template use File | Settings | File Templates.
 */
public enum ResourceManager {
    MANAGER;

    public void loadObject(GameObject gameObject, String file) {
        XMLParser parser = new XMLParser(file);

        for (Node entityEl : parser.root.children) {
            for (Node el : entityEl.children) {
                if (el.name.equals("position"))
                    gameObject.setPosition(el.readFloatArray());
                else if (el.name.equals("width"))
                    gameObject.setWidth(el.readInt());
                else if (el.name.equals("height"))
                    gameObject.setHeight(el.readInt());
                else if (el.name.equals("mass"))
                    gameObject.setMass(el.readFloat());
                else if (el.name.equals("animationFile")) {
                    gameObject.setAnimationFile(el.readString());
                }
                else if (el.name.equals("scriptFile")) {
                    gameObject.setScriptFile(el.readString());
                }
                else if (el.name.equals("lightRadius"))
                    gameObject.setLightRadius(el.readFloat());
            }
        }
    }

    public void loadAnimations(GameObject gameObject, String file) {
        XMLParser textureFile = new XMLParser(file);

        for (Node rootEl : textureFile.root.children) { //only one
            for (Node animEl : rootEl.children) {
                Animation animation = new Animation();
                animation.key = animEl.name;
                for (Node textEl : animEl.children) {
                    if (textEl.name.equals("speed")) {
                        animation.speedNano = textEl.readInt();
                    }
                    else if (textEl.name.equals("frame")) {
                        String texFile = textEl.readString();
                        String type = file.substring(file.indexOf(".") + 1).toUpperCase();
                        try {
                            Texture texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream(texFile));
                            animation.frames.add(texture);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                gameObject.animations.put(animation.key, animation);
            }
        }
    }

}
