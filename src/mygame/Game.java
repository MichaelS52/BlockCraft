/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import jme3tools.optimize.GeometryBatchFactory;
import mygame.terrain.Block;
import mygame.terrain.Chunk;
import mygame.terrain.World;
import mygame.utils.Location;

/**
 *
 * @author MrToaster111
 */
public class Game extends SimpleApplication implements ActionListener{

    

    private boolean left = false, right = false, up = false, down = false;
    public static World w;
    public static Node root;
    DirectionalLight sun;
    public static int renderDis = 6;
    
    @Override
    public void simpleInitApp() {
        Materials.loadMaterials(assetManager);
        flyCam.setEnabled(true);
        flyCam.setMoveSpeed(30);
        this.root = rootNode;

        BulletAppState bullet = new BulletAppState();
        stateManager.attach(bullet);
        
        Node myCharacter = new Node();
        rootNode.attachChild(myCharacter);
        // Create a appropriate physical shape for it
        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
        CharacterControl myCharacter_phys = new CharacterControl(capsuleShape, 0.01f);
        // Attach physical properties to model and PhysicsSpace
        myCharacter.addControl(myCharacter_phys);
        //bulletAppState.getPhysicsSpace().add(myCharacter_phys);
        
        
        Node player = new Node();
        Node playerNode = new Node(); // You can create a new node to wrap your player to adjust the location. (This allows you to solve issues with character sinking into floor, etc.)
        playerNode.attachChild(player); // add it to the wrapper
        player.move(0,3.5f,0); // adjust position to ensure collisions occur correctly.
        player.setLocalScale(0.5f); // optionally adjust scale of model
        // setup animation:
        BetterCharacterControl playerControl = new BetterCharacterControl(1.5f, 6f, 1f); // construct character. (If your character bounces, try increasing height and weight.)
        playerNode.addControl(playerControl); // attach to wrapper
        // set basic physical properties:
        playerControl.setJumpForce(new Vector3f(0,5f,0)); 
        playerControl.setGravity(new Vector3f(0,1f,0));
        playerControl.warp(new Vector3f(0,10,10)); // warp character into landscape at particular location
        // add to physics state
        //bulletAppState.getPhysicsSpace().add(playerControl); 
        //bulletAppState.getPhysicsSpace().addAll(playerNode); 
        rootNode.attachChild(playerNode); // add wrapper to root
        
        this.cam.setLocation(new Vector3f(0,50,0));
        setUpKeys();
        
        Block b = new Block(1, 1, 1, 3);
        b.place();
        rootNode.attachChild(b);
        
        w = new World();
        rootNode.attachChild(w);
        System.out.println("Added new World!");
        
        sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White);
        sun.setDirection(cam.getDirection());
        rootNode.addLight(sun);
        
         final int SHADOWMAP_SIZE=1024;
        DirectionalLightShadowRenderer dlsr = new DirectionalLightShadowRenderer(assetManager, SHADOWMAP_SIZE, 3);
        dlsr.setLight(sun);
        viewPort.addProcessor(dlsr);

        DirectionalLightShadowFilter dlsf = new DirectionalLightShadowFilter(assetManager, SHADOWMAP_SIZE, 3);
        dlsf.setLight(sun);
        dlsf.setEnabled(true);
        FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
        fpp.addFilter(dlsf);
        viewPort.addProcessor(fpp);
    }
    private void setUpKeys() {
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(this, "Left");
        inputManager.addListener(this, "Right");
        inputManager.addListener(this, "Up");
        inputManager.addListener(this, "Down");
        inputManager.addListener(this, "Jump");
  }
    
    @Override
    public void simpleUpdate(float tpf) {
        // make the player rotate:
        Location camLoc = new Location(cam.getLocation().x,cam.getLocation().getY(),cam.getLocation().getZ());
        camLoc.loadAdjacentChunks(renderDis);
        this.sun.setDirection(cam.getDirection());
    }
    
    

    public void onAction(String binding, boolean isPressed, float tpf) {
        if (binding.equals("Left")) {
      left = isPressed;
    } else if (binding.equals("Right")) {
      right= isPressed;
    } else if (binding.equals("Up")) {
      up = isPressed;
    } else if (binding.equals("Down")) {
      down = isPressed;
    } else if (binding.equals("Jump")) {
      if (isPressed) {  }
    }
    }

    
    
}
