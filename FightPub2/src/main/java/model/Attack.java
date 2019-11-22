/*
 * Copyright (C) 2019 flatline
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

import view.Timer;

/**
 * This class is used to set attack values of playerEntitys hitbox when he uses
 * Attack
 *
 * @see PlayerEntity
 * @author Pate, Joonas
 *
 */
public class Attack {

    final int damage;
    final int width;
    final int height;
    final int xOffset;
    final int yOffset;
    final int hitStun;
    final int blockStun;
    final int activationTime; //this is the time when the hit will activate so when timer == activation time the hit activates
    int activation;
    final int deactivationTimeFINAL = 50;
    int deactivationTime;
    HitBox.HitLocation loc;
    PlayerEntity player;
    Timer frameClock;

    /**
     *
     * @param damage how much damage the hit does
     * @param width how wide the hitbox is
     * @param height how tall the hitbox is
     * @param xOffset distance form characters outer corner in relation to the
     * other charactter
     * @param yOffset distance from the floor to the hitbox's left bottom corner
     * @param hitStun how long the player who gets hit by this attack will be in
     * hitStun state in frames
     * @param blockStun how long the player who blocks this attack will be in
     * blockStun state in frames
     * @param loc defines is the attack low mid or high so can it be blocked in
     * which positions
     * @param player wich player owns this attack
     */
    public Attack(int damage, int width, int height, int xOffset, int yOffset, int hitStun, int blockStun, HitBox.HitLocation loc, PlayerEntity player) {
        this.damage = damage;
        this.width = width;
        this.height = height;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.hitStun = hitStun;
        this.blockStun = blockStun;
        this.loc = loc;
        this.player = player;
        this.frameClock = frameClock.getInstance();
        this.activationTime = 15;
    }

    /**
     * Sets the hitbox values of the hitbox object when the character uses a
     * specific attack
     */
    public void updateHitbox() {
        if (player.getState() == PlayerEntity.State.ATTACKING) {
            if (deactivationTime <= frameClock.getFpsCounter()) {
                player.getHitBox().deactivate();
                player.setState(PlayerEntity.State.NEUTRAL);
                System.out.println(frameClock.getFpsCounter() - activation);
            } else if (activation + activationTime == frameClock.getFpsCounter()) {
                int tempXoffSet = this.xOffset;
                if (player.getFacing() == PlayerEntity.Facing.LEFT) {
                    tempXoffSet = player.getWidth() - this.xOffset - this.width;
                }
                player.getHitBox().setAll(this.damage, this.width, this.height, tempXoffSet, this.yOffset, this.hitStun, this.blockStun, this.loc);
            }
        }

    }

    public void activateAttack() {
        player.setState(PlayerEntity.State.ATTACKING);

        // 100
        activation = frameClock.getFpsCounter();
        //110
        deactivationTime = deactivationTimeFINAL + activation;
        
        System.out.println("Hyökätty" + frameClock.getFpsCounter());
        System.out.println("Deactiotion time" + (deactivationTime - activation));

    }

}
