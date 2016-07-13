/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import mygame.terrain.Block;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import mygame.terrain.World;

/**
 *
 * @author MrToaster111
 */
public class Game extends SimpleApplication implements ActionListener{

    @Override
    public void simpleInitApp() {
        Materials.loadMaterials(assetManager);
        /*cam.setLocation(new Vector3f(0,0,0));
        CapsuleCollisionShape capsule = new CapsuleCollisionShape(0.25f, 1.8f, 1);
        CharacterControl player3 = new CharacterControl(capsule, 0.5f);
        player3.setJumpSpeed(10);
        player3.setFallSpeed(10);
        player3.setGravity(10);*/
        
        this.cam.setLocation(new Vector3f(0,25,0));
        
        Block b = new Block(1, 1, 1, 3);
        b.place();
        rootNode.attachChild(b);
        
        World w = new World(128, 128);
        rootNode.attachChild(w);
        w.addChunk(0, 0);
        System.out.println("Added new World!");
    }

    public void onAction(String name, boolean isPressed, float tpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
