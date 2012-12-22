package com.lezend.core;

import com.lezend.managers.GraphicsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 1:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private final List<GameObject> gameObjectList;
    private final GameWorld gameWorld;

    private Game(GameBuilder gb) {
        gameObjectList = new ArrayList<GameObject>();
        gameWorld      = gb.gameWorld;

        GraphicsManager.MANAGER.setWindowX(gb.x);
        GraphicsManager.MANAGER.setWindowY(gb.y);
        GraphicsManager.MANAGER.setWindowWidth(gb.width);
        GraphicsManager.MANAGER.setWindowHeight(gb.height);
        GraphicsManager.MANAGER.setNearZ(gb.nearZ);
        GraphicsManager.MANAGER.setFarZ(gb.farZ);
        GraphicsManager.MANAGER.setFullScreen(false);

        GraphicsManager.MANAGER.init();
    }

    public void start() {
        loop();
    }

    private void loop() {
        while (GraphicsManager.MANAGER.isCloseRequested() == false) {
            GraphicsManager.MANAGER.reset();
            updateGameObjects();
            GraphicsManager.MANAGER.drawScreen();
        }
        //TODO: Kill the entire game
        GraphicsManager.MANAGER.destroy();
    }

    private void updateGameObjects() {
        for (GameObject gameObject : gameObjectList)
            gameObject.update(gameWorld);
    }

    public List<GameObject> getGameObjectList() {
        return gameObjectList;
    }

    /* Inner builder class-- helps to instantiate the game object at once, rather than relying on the developer to
     * to instantiate each component in the correct order.
     */

    public static class GameBuilder {

        private int x;
        private int y;
        private int width;
        private int height;
        private float frust;
        private float nearZ, farZ;
        private GameWorld gameWorld;

        public GameBuilder() {}

        public GameBuilder screenResolution(int width, int height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public GameBuilder frust(float f) {
            this.frust = f;
            return this;
        }

        public GameBuilder clipping(float near, float far) {
            this.nearZ = near;
            this.farZ = far;
            return this;
        }

        public GameBuilder gameWorld(GameWorld gameWorld) {
            this.gameWorld = gameWorld;
            return this;
        }

        public GameBuilder screenPosition(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public Game build() {
            return new Game(this);
        }

    }

    public void addObject(GameObject gameObject) {
        gameObjectList.add(gameObject);
    }
}
