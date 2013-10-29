/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author jordan
 */
public class GameEngine extends BasicGame {    
    SpriteSheet ss;
    MovableObject player;
    public GameEngine(String gameName) {
        super(gameName);
    }

    @Override
    public void update(GameContainer container, int i) {
        player.Update();
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        container.setTargetFrameRate(60);
        //container.setMaximumLogicUpdateInterval(10);
        container.setVSync(true);        
        
        //Load the main character.
        player = new GeraldAssetLoader().GetAssets().get(0);
    }

    @Override
    public void render(GameContainer container, Graphics g) {
        //g.draw(player.GetRectangle());
        player.draw(player.GetX(), player.GetY());
    }

    @Override
    public void keyPressed(int key, char c) {
        if (c == 'd') {
            player.SetMoving(true);
            player.SetDirection(Direction.Right);
        }
        else if(c == 'a'){
            player.SetMoving(true);
            player.SetDirection(Direction.Left);
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        if(c == 'd' || c == 'a'){
            player.SetMoving(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new GameEngine("Simple Slick Game"));
            appgc.setDisplayMode(640, 480, false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
