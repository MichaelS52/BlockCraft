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
    
    public Chunk[][] chunks;
    public static float[][] perlinNoise;
    public static int sizeX, sizeZ;
    
    public World(int sizeX, int sizeZ){
        if(sizeX%16==0 && sizeZ%16==0){
            this.chunks=new Chunk[sizeX/16][sizeZ/16];
            int widthX = sizeX/16;
            int widthZ = sizeZ/16;
            for(int x=0; x<widthX; x++){
                for(int z=0; z<widthZ; z++){
                    this.chunks[x][z]=addChunk(x, z);
                }
                DirectionalLight sun = new DirectionalLight();
                sun.setColor(ColorRGBA.LightGray);
                sun.setDirection(new Vector3f(-.5f,-.2f,-.5f).normalizeLocal());
                addLight(sun);
            }
        }else{
            throw new ArithmeticException("World size invalid, must be a multiple of 16.");
        }
        
    }
    
    public Chunk addChunk(int x, int z){
        Chunk c = new Chunk(x,z, new Location(.2d,40d,.2d));
        c.setLocalTranslation(x*16, .5f, z*16);
        attachChild(c);
        chunks[x][z]=c;
        return c;
    }
    
    
    
}
