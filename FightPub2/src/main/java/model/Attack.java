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

/**
 *
 * @author flatline
 */
public class Attack {

    int damage;
    int width;
    int height;
    int xOffset;
    int yOffset;
    int hitStun;
    int blockStun;
    int timer;
    int activationTime;
    HitBox.HitLocation loc;
    PlayerEntity player;

    //int winduptime
    //timer käynynnistyy ku nappii painetaaan
    //ite säädetään int activationTime joka kertoo missä pisteessä timerin pitää olla jotta hitbox aktivoituu
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
    }

    public void setHitBox() {
        int tempXoffSet = this.xOffset;
        if (player.getFacing() == PlayerEntity.Facing.LEFT) {
            tempXoffSet = player.getHurtbox().getWidth() - this.xOffset - this.width;
        }
        if (timer == activationTime) {
            player.getHitBox().setAll(this.damage, this.width, this.height, tempXoffSet, this.yOffset, this.hitStun, this.blockStun, this.loc);
        }

        
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(int activationTime) {
        this.activationTime = activationTime;
    }

}
