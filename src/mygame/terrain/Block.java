/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.terrain;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import mygame.Materials;

/**
 *
 * @author MrToaster111
 */
public class Block extends Geometry{
    
    int x, y, z, id;
    
    public Block(int x, int y, int z, int id){
        this.x=x;
        this.y=y;
        this.z=z;
        this.id=id;
        
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getZ(){
        return this.z;
    }
    
    public int getId(){
        return this.id;
        
    }
    
    //TODO (with texture)
    public void place(){
        setMesh(new Box(.5f, .5f, .5f));
        Material mat = Materials.MATERIALS[this.id];
        setMaterial(mat);
        setLocalTranslation(this.x, this.y, this.z);
        setName("Box");
        setShadowMode(shadowMode.CastAndReceive);
    }
    
}
