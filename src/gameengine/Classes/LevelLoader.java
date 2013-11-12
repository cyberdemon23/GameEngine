/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameengine.Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author jordan
 */
public class LevelLoader {
    private int[][] _worldMap;
    private final String _filePath;
    private int _mapHeight;
    private int _mapWidth;
    private String _backgroundImageFile;
    private String _tileMapImageFile;
    private int _currentMapLine = 0;
    
    public LevelLoader(String levelFilePath){
        _filePath = levelFilePath;
    }
    
    public boolean LoadLevelData(){
        boolean success = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(_filePath));
            String line;
            
            try {
                while((line = br.readLine()) != null){
                    ParseMapLine(line);
                }
            } catch (IOException ex) {
                success = false;
                Logger.getLogger(LevelLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            success = false;
            Logger.getLogger(LevelLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    private void ParseMapLine(String line){
        //Load map length data.
        if(line.contains("HxW:")){
            line = line.substring(line.lastIndexOf(":") + 1);
            String[] vals = line.split("x");
            
            if(vals.length == 2){
                _mapHeight = Integer.parseInt(vals[0]);
                _mapWidth = Integer.parseInt(vals[1]);
                
                _worldMap = new int[_mapHeight][_mapWidth];
            }
        }
        //Load Map Background Image
        else if(line.contains("Background:")){
            line = line.substring(line.lastIndexOf(":") + 1);
            
            _backgroundImageFile = line;
        }
        //Load Map Tile Sheet
        else if(line.contains("TileMap:")){
            line = line.substring(line.lastIndexOf(":") + 1);
            
            _tileMapImageFile = line;
        }
        //Must be map info
        else{
            String[] mapLine = line.split(" ");
            
            for(int i = 0; i < mapLine.length; i++){
                _worldMap[_currentMapLine][i] = Integer.parseInt(mapLine[i]);
            }
            
            _currentMapLine++;
        }
    }
}
