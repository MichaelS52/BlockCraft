/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.terrain;

import java.util.ArrayList;

/**
 *
 * @author MrToaster111
 */
public class ChunkManager {
    
    public static ArrayList<Chunk> chunks = new ArrayList<Chunk>();
    
    public static Chunk getChunkAt(int x, int z){
        for(Chunk ch : chunks){
            if(ch.x == x && ch.z == z){
                return ch;
            }
        }
        return null;
    }
    
    public static ArrayList<Chunk> getLoadedChunks(){
        ArrayList<Chunk> loaded = new ArrayList<Chunk>();
        for(Chunk ch : chunks){
            if(ch.isLoaded){
                loaded.add(ch);
            }
        }
        return loaded;
    }
    
}
