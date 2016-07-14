/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.terrain;

import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;
import java.util.ArrayList;
import jme3tools.optimize.GeometryBatchFactory;
import mygame.Game;
import mygame.generators.Perlin;
import mygame.utils.Location;

/**
 *
 * @author MrToaster111
 */

    

public class Chunk extends Node{
    
    int x, z;
    public static final int BIG_NUMBER = (int) Math.pow(2, 18);
    public Block[][][] blocks;
    public ArrayList<Block> blocksList = new ArrayList<Block>();
    public Location dilation;
    public boolean isLoaded = false;
    public boolean hasBeenGenerated = false;
    
    public Chunk(int i, int j, Location dial){
        this.x=i;
        this.z=j;
        this.dilation=dial;
        this.blocks=new Block[16][256][16];
        //generate();
    }
    
    public void optimize(){
        GeometryBatchFactory.optimize(this);
    }
    
    public void generate() {
          if(this.hasBeenGenerated){
              Game.w.attachChild(this);
              return;
          }
          this.isLoaded=true;
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				float x = (float) this.x * 16 + i;
				float z = (float) this.z * 16 + j;
				float y = (int) dilation.getY() * ((Perlin.perlin2D((float)(x * dilation.getX() + BIG_NUMBER),(float)( z * dilation.getZ() + BIG_NUMBER) + 1)) / 2) + 1;

				for (int k = 0; k < 256; k++) {
                                        boolean isNonAir=false;
					if (k < y) {
						//place block
                                                isNonAir=true;
                                                Block b = new Block(i,k,j,3);
                                                //Save block
                                                blocks[i][k][j]=b;
                                                blocksList.add(b);
                                                b.place();
                                                attachChild(b);
                                                
					} else if(k==0 || k==-1){
                                               if(!isNonAir){
                                               Block b = new Block(i,k,j,4);
                                               //Save block
                                               blocks[i][k][j]=b;
                                               blocksList.add(b);
                                               b.place();
                                               attachChild(b);
                                               }
					}
				}
			}
		}
                this.hasBeenGenerated=true;
                this.optimize();
	}
    
    public boolean isLoaded(){
        return this.isLoaded;
    }
    
    public void unLoad(){
        if(isLoaded){
            System.out.println("Unloaded chunk.");
            isLoaded=false;
            this.removeFromParent();
        }
    }
}
