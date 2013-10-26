/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jordan
 */
public class GameEngine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        GameWindow w = new GameWindow();
        w.setVisible(true);
    }
}

class Surface extends JPanel{
    
    private Rectangle rect = new Rectangle(0,0,25,25);
    
    public void updateRect(int x, int y){
        rect.x = x;
        rect.y = y;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.fill(rect);
    }
}

class GameWindow extends JFrame{
    private Surface s = new Surface();
    
    public GameWindow() throws InterruptedException{
        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 400);
        
        add(s);
        
        GameLoop();
    }
    
    private void GameLoop() throws InterruptedException{
        boolean gameRunning = true;
        int i = 0;
        
        while(gameRunning){
            i++;
            s.updateRect(i, i);
            s.revalidate();
            
            if(i == 100) gameRunning = false;
        }
    }
}
