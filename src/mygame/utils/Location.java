/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.utils;

import java.util.ArrayList;
import mygame.Game;
import mygame.terrain.Chunk;
import mygame.terrain.ChunkManager;

/**
 *
 * @author MrToaster111
 */
public class Location {
    
    double x, y, z;
    
    public Location(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    public double getZ(){
        return this.z;
    }
    
    public Chunk getChunk(){
        int x16 = (int)this.x-(int)this.x%16;
        int z16 = (int)this.z-(int)this.z%16;
        x16/=16;
        z16/=16;
        Chunk c = ChunkManager.getChunkAt(x16, z16);
        if(c==null){
            return Game.w.addChunk(x16, z16);
        }else{
            return c;
        }

    }
    
    public void loadAdjacentChunks(int renderDis){
        if(renderDis%2==0){
            //Must be even
            ArrayList<Chunk> changed = new ArrayList<Chunk>();
            int eachDir = renderDis/2;
            Location least = new Location(this.x-(eachDir*16),this.y,this.z-(eachDir*16));
            for(int x=0; x<renderDis*16; x+=16){
                for(int z=0; z<renderDis*16; z+=16){
                    Location l = new Location(least.x+x,0,least.z+z);
                    changed.add(l.getChunk());
                    if(!l.getChunk().isLoaded()){
                        l.getChunk().generate();
                    }
                }
            }
            
            ArrayList<Chunk> loaded = ChunkManager.getLoadedChunks();
            for(Chunk c : loaded){
                if(!changed.contains(c)){
                    //Unload
                    c.unLoad();
                }
            }
            
        }else{
            throw new NumberFormatException("Cannot have a odd number as a render distance");
        }
        
    }
    
}
