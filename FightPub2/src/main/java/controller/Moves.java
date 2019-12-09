/*
 * Copyright (C) 2019 Heidi
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
package controller;

import model.PlayerEntity;
import controller.Controller;

/**
 *
 * @author Heidi
 */
public class Moves {
    Controller c;
    String save= "";
    String[] list = new String[4];
    public Moves(Controller c){
        this.c = c;
    }
    
    /**
     * Gets information about inputs and player position. 
     * Updates player position with the information.
     * @param char1 moving character
     * @param char2 enemy character
     * @param move pressed input
     * @param save saved input
     * @return x1, y1, savedMove, Stance
     */
    public String[] getMove(PlayerEntity char1,PlayerEntity char2, String move, String save) {
        int x1 = char1.getxCoord();
        int y1 = char1.getyCoord();
        this.save = save;
        PlayerEntity.Stance stance =char1.getStance();
        
        //Actions, when character is in jump stance
        if (stance== PlayerEntity.Stance.JUMPING){
            if (y1!=600){
                y1 = y1+12;
                if ("Right".equals(save)){
                    x1 = char1.getxCoord()+char1.getWalkspeed();
                }
                if("Left".equals(save)){
                    x1 = char1.getxCoord()-char1.getWalkspeed();
                }
            }else stance=PlayerEntity.Stance.STANDING;
        }
        if(stance== PlayerEntity.Stance.STANDING && y1!=0){
            y1 = y1-12;
            if ("Right".equals(save)){
                x1 = x1+char1.getWalkspeed();
            }
            if("Left".equals(save)){
                x1 = x1-char1.getWalkspeed();
            }
        }
        
        // Player moves when stance is STANDING.
        if (stance!= PlayerEntity.Stance.JUMPING && y1==0){
            if ("Left".equals(move)){
                x1 = x1-char1.getWalkspeed();
            }
            if ("Right".equals(move)){
                 x1 = x1+char1.getWalkspeed();
            }
            if ("Down".equals(move)){
                stance = PlayerEntity.Stance.CROUCHING;
            }
            if ("Down Left".equals(move)){
                stance = PlayerEntity.Stance.CROUCHING;
                x1 = x1-char1.getWalkspeed()/2;
            }
            if ("Down Right".equals(move)){
                stance = PlayerEntity.Stance.CROUCHING;
                x1 = x1+char1.getWalkspeed()/2;
            }
            if ("Up".equals(move)){
                stance = PlayerEntity.Stance.JUMPING;
                save="";
            }
            if ("Up Left".equals(move)){
                save = "Left";
                stance = PlayerEntity.Stance.JUMPING;
            }
            if ("Up Right".equals(move)){
                save = "Right";
                stance = PlayerEntity.Stance.JUMPING;
            }
        }
        list[0] = Integer.toString(x1);
        list[1] = Integer.toString(y1);
        list[2] = save;
        list[3] = String.valueOf(stance);
        //System.out.println(stance);
        return list;
    }
    
}
