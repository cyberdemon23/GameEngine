/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameengine.Interfaces;

import gameengine.Classes.MovableObject;
import java.util.ArrayList;

/**
 *
 * @author jordan
 */
public interface IAssetLoader {
    ArrayList<MovableObject> GetAssets();
}
