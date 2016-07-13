/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.texture.Texture;

/**
 *
 * @author MrToaster111
 */
public class Materials {
    
     public static Material[] MATERIALS = new Material[10];
    
    /**
     * Loads block materials
     * @param assetManager 
     */
    public static void loadMaterials(AssetManager assetManager)
    {
        MATERIALS[1] = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        MATERIALS[1].setColor("Color", ColorRGBA.Blue);
        
        MATERIALS[2] = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        MATERIALS[2].setColor("Color", ColorRGBA.Red);
        
        MATERIALS[3] = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        Texture gras = assetManager.loadTexture(new TextureKey("Textures/grasstop1.png",false));
        MATERIALS[3].setReceivesShadows(true);
        MATERIALS[3].setTexture("ColorMap", gras);
        
        
        MATERIALS[4] = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        Texture water = assetManager.loadTexture(new TextureKey("Textures/water.png",false));
        MATERIALS[4].setTexture("ColorMap", water);
    }
    
}
