/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author jordan
 */
public class GameEngine extends BasicGame {
    int x = 0;
    int y = 0;
    
    public GameEngine(String gameName) {
        super(gameName);
    }

    @Override
    public void update(GameContainer container, int i) {
        x++;
        y++;
    }

    @Override
    public void init(GameContainer container) {

    }

    @Override
    public void render(GameContainer container, Graphics g) {
        g.drawString("What the shit!?", 250, 220);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
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

class Controller implements KeyListener {

    public boolean moving = false;

    @Override
    public void keyPressed(KeyEvent e) {
        moving = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
