/*
 * Copyright (C) 2019 Pate
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
package model;


/**
 *
 * @author Pate
 */
import model.Character;
public class HitBox {
    
    int xcoord, width, height, damage, xoffset, yoffset;
    final Character owner;
            
    
    //this constructor might be better suited for our needs.
    public HitBox (int xcoord, int width, int height, int xoffset, int yoffset,int damage, Character owner) {
        this.width = width;
        this.height = height;
        this.damage = damage;
        this.xoffset = xoffset;
        this.yoffset = yoffset;
        this.owner = owner;
    }
    
    // ---------------- GETTERS AND SETTERS ---------------
 

    public int getxCoord() {
        return this.xcoord;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
