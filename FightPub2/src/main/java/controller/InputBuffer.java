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

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import controller.inputcheck;

/**
 *
 * @author Heidi, Antti
 */
public class InputBuffer {
    inputcheck check = new inputcheck();
    Stack<String> player1ST = new Stack<>();
    Stack<String> player2ST = new Stack<>();
    LinkedList<String> player1Q = new LinkedList<>();
    LinkedList<String> player2Q = new LinkedList<>();
    private String latest1 = "";
    private String latest2 = "";
    
    /**
     * saves string to Stack and LinkedList for player 1
     * @param string 
     */
    public void player1Add(String string){
        player1ST.add(string);
        if (latest1 != ""){
            if (latest1 != string){
                player1Q.add(string);
                latest1 = string;
            }
        }else{
            player1Q.add(string);
            latest1 = string;
        } 
        if (player1Q.size() > 4){
            String p =player1Q.poll();
        }   
    }
    
    /**
     * saves string to Stack and LinkedList for player 2
     * @param string 
     */
    public void player2Add(String string){
        player2ST.add(string);
        if (latest2 != ""){
            if (latest2 != string){
                player2Q.add(string);
                latest2 = string;
            }
        }else{
            player2Q.add(string);
            latest2 = string;
        } 
        if (player2Q.size() > 4){
            String p =player2Q.poll();
        }
    }
    
    /**
     * uses checkinput to get current move for player1
     * @return move
     */
    public String player1GetMove(){
        String polled1 ="";
        String polled2 ="";
        polled1 = player1ST.pop();
        try {
            polled2 = player1ST.pop();
        }catch (Exception e){};
        player1ST.clear();
        return check.checkMoveInputs(polled1, polled2);
    }
    
    /**
     * uses checkinput to get current move for player2
     * @return move
     */
    public String player2GetMove(){
        String polled1 ="";
        String polled2 ="";
        polled1 = player2ST.pop();
        try {
            polled2 = player2ST.pop();
        }catch (Exception e){};
        player2ST.clear();
        return check.checkMoveInputs(polled1, polled2);
    }

    //Iskuille oma imputbuffer, joka tyhjenee ku painaa (A)(B)(C),jne
    /**
     * uses checkinput to get current attack for player1
     * @return attack
     */
    public String[] player1Inputs(){
         String[] inputs = null;
         for (int i = 0; player1Q.size()>i; i++) {
             inputs[i] = player1Q.poll();
         }
         player2Q.clear();
         return inputs;
     }
     
    /**
     * uses checkinput to get current attack for player2
     * @return attack
     */
     public String[] player2Inputs(){
        String[] inputs = null;
        for (int i = 0; player2Q.size()>i; i++) {
            inputs[i] = player2Q.poll();
             
        }
        player2Q.clear();
        return inputs;
    }
    //Iskut arraylistaan move-osastolle
    
}
