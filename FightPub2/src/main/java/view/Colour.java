/*
 * Copyright (C) 2019 antti
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package view;

/**
 * Data class to store RGB values as floats
 * @author antti
 */
public class Colour {
    
    public static final Colour WHITE = new Colour(1f, 1f, 1f);
    public static final Colour BLACK = new Colour(0f, 0f, 0f);
    public static final Colour RED = new Colour(1f, 0f, 0f);
    public static final Colour GREEN = new Colour(0f, 1f, 0f);
    public static final Colour BLUE = new Colour(0f, 0f, 1f);
    
    private float r;
    private float g;
    private float b;
    private float a;
    
    /**
     * Constructor creates a new RGB colour from float values that can be used in rendering
     * @param r red value between 0.0 and 1.0
     * @param g green value between 0.0 and 1.0
     * @param b blue value between 0.0 and 1.0
     */
    public Colour(float r, float g, float b){
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 1f;
    }
    
     /**
     * Constructor creates a new RGB colour from float values that can be used in rendering
     * @param r red value between 0.0 and 1.0
     * @param g green value between 0.0 and 1.0
     * @param b blue value between 0.0 and 1.0
     * @param a blue value between 0.0 and 1.0
     */
    public Colour(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
    
    public void setR(float r){
        this.r = r;
    }
    
    public void setG(float g){
        this.g = g;
    }
        
    public void setB(float b){
        this.b = b;
    }

    public void setA(float a) {
        this.a = a;
    }   
    
    public float getR(){
        return this.r;
    }
    
    public float getG(){
        return this.g;
    }
    
    public float getB(){
        return this.b;
    }

    public float getA() {
        return a;
    }
    
}
