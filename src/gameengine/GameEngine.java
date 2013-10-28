/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author jordan
 */
public class GameEngine extends BasicGame {

    Rectangle rect = new Rectangle(10, 10, 50, 50);
    boolean moving = false;
    Direction direction = Direction.Left;

    public GameEngine(String gameName) {
        super(gameName);
    }

    @Override
    public void update(GameContainer container, int i) {
        if (moving) {
            if (direction == Direction.Right) {
                rect.setX(rect.getX() + 5);
            }
            else if(direction == Direction.Left){
                rect.setX(rect.getX() - 5);
            }
        }
    }

    @Override
    public void init(GameContainer container) {

    }

    @Override
    public void render(GameContainer container, Graphics g) {
        g.draw(rect);
    }

    @Override
    public void keyPressed(int key, char c) {
        if (c == 'd') {
            moving = true;
            direction = Direction.Right;
        }
        else if(c == 'a'){
            moving = true;
            direction = Direction.Left;
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        if(c == 'd' || c == 'a'){
            moving = false;
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

enum Direction {
    Left, Right;
}
