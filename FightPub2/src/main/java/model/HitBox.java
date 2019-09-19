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
public class HitBox {
    
    int location, width, height, damage;
    
    //this constructor might not see any use.
    public HitBox (int location, int width, int height, int damage) {
        this.location = location;
        this.width = width;
        this.height = height;
        this.damage = damage;  
    }
    
    //this constructor might be better suited for our needs.
    public HitBox (int width, int height, int damage) {
        this.width = width;
        this.height = height;
        this.damage = damage;
    }
    
    // ---------------- GETTERS AND SETTERS ---------------
 

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
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
