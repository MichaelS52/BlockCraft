/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.terrain;

import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.utils.Location;
import mygame.utils.LocationXZ;

/**
 *
 * @author MrToaster111
 */
public class World extends Node{
    
    public static float[][] perlinNoise;
    
    public World(){
        
    }
    
    public Chunk addChunk(int x, int z){
        Chunk c = new Chunk(x,z, new Location(.2d,80d,.2d));
        c.setLocalTranslation(x*16, .5f, z*16);
        attachChild(c);
        ChunkManager.chunks.add(c);
        return c;
    }
    
    
    
}
