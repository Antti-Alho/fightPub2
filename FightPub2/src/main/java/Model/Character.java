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
package Model;

/**
 *
 * @author Pate
 */
public class Character {
    
    public int xCoord;
    public int health = 100;
    boolean player1 = false;
    boolean facingRight = false;
    boolean STATE_HITSTUN = false, STATE_ATTACK = false, STATE_BLOCKSTUN = false;
        
    HurtBox hurtBox = new HurtBox();
    
    public Character (boolean player1, boolean facingRight) {
       this.player1 = player1;
       this.facingRight = facingRight;      
       hurtBox.setXcoord(xCoord);
        
    }
    
    
}