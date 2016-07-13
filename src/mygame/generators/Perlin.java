/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.generators;

/**
 *
 * @author MrToaster111
 */

public class Perlin {
	public static final float P = 0.5f;
	public static final int OCTAVES = 1;
	
	public static float perlin2D(float x, float y) {	
		float total = 0.0f;
		
		for (int i = 0; i < OCTAVES; i++) {
			int frequency = (int) Math.pow(2, i);
			float amplitude = (float) Math.pow(P, i);
			
			total += Noise2D.interpolate(x * frequency, y * frequency, Noise1D.primes[0]) * amplitude;
		}
		
		return total;
	}
}