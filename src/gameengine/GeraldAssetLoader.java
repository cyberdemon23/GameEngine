/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author cyber_000
 */
public class GeraldAssetLoader implements IAssetLoader {

    @Override
    public ArrayList<MovableObject> GetAssets() {
        ArrayList<MovableObject> assets = new ArrayList<MovableObject>(1);

        Image i;
        try {
            Rectangle rect = new Rectangle(10, 200, 50, 50);
            i = new Image("Assets/Gerald_Prototype.png", false, 1, Color.white);
            SpriteSheet ss = new SpriteSheet(i, 61, 95);
            assets.add(new MovableObject(rect, 5, ss, 1));
        } catch (SlickException ex) {
            Logger.getLogger(GeraldAssetLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return assets;
    }
}
