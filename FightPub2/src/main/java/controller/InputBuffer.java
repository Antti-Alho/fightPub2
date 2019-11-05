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

import java.util.PriorityQueue;

/**
 *
 * @author Heidi, Antti
 */
public class InputBuffer {
    PriorityQueue<String> player1Q = new PriorityQueue<>();
    PriorityQueue<String> player2Q = new PriorityQueue<>();
    
    public void player1Add(String string){
        player1Q.add(string);
    }
    
    public void player2Add(String string){
        player2Q.add(string);
    }
    
    public String player1GetInput(){
        String polled = "";
        polled = player1Q.poll();
        player1Q.clear();
        if (polled == null) return "";
        return polled;
    }
    
     public String player2GetInput(){
        String polled = "";
        polled = player2Q.poll();
        player2Q.clear();
        if (polled == null) return "";
        return polled;
    }
}
