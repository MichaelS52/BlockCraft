/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.terrain;

import com.jme3.scene.Node;
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
    public Location dilation;
    
    public Chunk(int i, int j, Location dial){
        this.x=i;
        this.z=j;
        this.dilation=dial;
        generate();
    }
    
    public void generate() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				float x = (float) this.x * 16 + i;
				float z = (float) this.z * 16 + j;
				float y = (int) dilation.getY() * ((Perlin.perlin2D((float)(x * dilation.getX() + BIG_NUMBER),(float)( z * dilation.getZ() + BIG_NUMBER) + 1)) / 2) + 1;

				for (int k = 0; k < 256; k++) {
					if (k <= y) {
						//place block
                                                Block b = new Block(i,k,j,3);
                                                b.place();
                                                attachChild(b);
					} else {
						 Block b = new Block(i,k,j,4);
                                                b.place();
                                                attachChild(b);	
					}
				}
			}
		}
	}
    
}
