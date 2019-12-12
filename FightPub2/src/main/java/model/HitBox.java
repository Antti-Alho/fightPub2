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
 * This class is used to create a rectangle which is used to hit another
 * character. Every instance of character class has an instance of this class.

 * @author Pate, Joonas
 */
public class HitBox {

    private int width, height, xoffset, yoffset, damage, hitStun, blockStun;

    private HitLocation hitLocation;

    /**
     * Constructor.
     *
     * @param width width of the hitbox in pixels.
     * @param height height of the hitbox in pixels.
     * @param xoffset distance from characters x coordinate in pixels.
     * @param yoffset distance from the characters top edge towards maps floor.
     * @param damage how much damage the hitbox does to other player if the
     * hitbox hits hurtbox
     * @param hitLocation Describes what type of hit the players uses. This
     * value is used to determine what kind of block the opponent player must
     * use in order to block the hit successfully
     */
    public HitBox(int width, int height, int xoffset, int yoffset, int damage, HitLocation hitLocation) {
        this.width = width;
        this.height = height;
        this.xoffset = xoffset;
        this.yoffset = yoffset;
        this.damage = damage;
        this.hitLocation = hitLocation;
    }

    /**
     * This enum value indicates if attack is blockable in certain stance. HIGH
     * attacks must be blocked STANDING MID attacks can be blocked either
     * STANDING or CROUCHING LOW attacks must be blocked CROUCHING
     */
    public enum HitLocation {
        HIGH,
        MID,
        LOW
    }

    /**
     * Helper method to set all parameters in single method
     *
     * @param damage
     * @param width
     * @param height
     * @param xOffset
     * @param yOffset
     * @param hitStun
     * @param blockStun
     * @param hitLocation
     */
    public void setAll(int damage, int width, int height, int xOffset, int yOffset, int hitStun, int blockStun, HitLocation hitLocation) {
        this.damage = damage;
        this.width = width;
        this.height = height;
        this.xoffset = xOffset;
        this.yoffset = yOffset;
        this.hitStun = hitStun;
        this.blockStun = blockStun;
        this.hitLocation = hitLocation;
    }
    /**
     * Deactivates the hitbox.
     */
    public void deactivate(){
        this.width = 0;
        this.height = 0;
    }
    // ---------------- GETTERS AND SETTERS ---------------

    public HitLocation getHitLocation() {
        return this.hitLocation;
    }

    public void setHitLocation(HitLocation hitLocation) {
        this.hitLocation = hitLocation;
    }

    public int getXoffset() {
        return xoffset;
    }

    public void setXoffset(int xoffset) {
        this.xoffset = xoffset;
    }

    public int getYoffset() {
        return yoffset;

    }

    public void setYoffset(int yoffset) {
        this.yoffset = yoffset;
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

    public int getHitStun() {
        return hitStun;
    }

    public void setHitStun(int hitStun) {
        this.hitStun = hitStun;
    }

    public int getBlockStun() {
        return blockStun;
    }

    public void setBlockStun(int blockStun) {
        this.blockStun = blockStun;
    }
    

}
