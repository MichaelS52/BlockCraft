/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.utils;

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
    
}
