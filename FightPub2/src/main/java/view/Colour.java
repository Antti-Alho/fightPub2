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
 * 
 * @author antti
 */
public class Colour {
    
    float r;
    float g;
    float b;
    
    public Colour(float r, float g, float b){
        this.r = r;
        this.g = g;
        this.b = b;
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
    
    public float getR(){
        return this.r;
    }
    
    public float getG(){
        return this.g;
    }
    
    public float getB(){
        return this.b;
    }
    
}
