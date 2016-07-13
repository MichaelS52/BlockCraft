/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.utils;

/**
 *
 * @author MrToaster111
 */
public class LocationXZ {
    
    double x, z;
    public LocationXZ(double x, double z){
        this.x=x;
        this.z=z;
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getZ(){
        return this.z;
    }
    
    public int getIntX(){
        return (int)this.x;
    }
    
    public int getIntZ(){
        return (int)this.z;
    }
    
}
