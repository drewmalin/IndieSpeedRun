package com.lezend.core;

import com.lezend.player.PlayerGraphicsComponent;
import com.lezend.player.PlayerInputComponent;
import com.lezend.player.PlayerPhysicsComponent;

/**
 * Created with IntelliJ IDEA.
 * User: drewmalin
 * Date: 12/22/12
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Game.GameBuilder gameBuilder = new Game.GameBuilder();

        gameBuilder.screenResolution(400, 400);
        gameBuilder.screenPosition(100, 100);
        gameBuilder.clipping(-1f, 1f);
        gameBuilder.gameWorld(new GameWorld());

        Game game = gameBuilder.build();

        game.addObject(
                new GameObject(
                        new PlayerGraphicsComponent(),
                        new PlayerPhysicsComponent(),
                        new PlayerInputComponent(),
                        "res/entities/Player.xml"
                )
        );

        game.start();
    }
}