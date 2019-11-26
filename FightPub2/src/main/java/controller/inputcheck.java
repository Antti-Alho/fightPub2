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

/**
 *
 * @author Heidi
 */
public class inputcheck {
    public inputcheck(){};
    
    /**
     * check what inputs player has used
     * @param first
     * @param second
     * @return move
     */
    public String checkMoveInputs(String first, String second){
            if (first == "Left" && second == "") return "Left";
            if (first == "Right" && second == "") return "Right";
            if (first == "Down" && second == "") return "Down";
            if (first == "Up" && second == "") return "Up";
            if (first == "A" && second == "") return "A";
            if (first == "Left" && second == "Down" || first == "Down" && second == "Left"){
                return "Down Left";
            }
            if (first == "Right" && second == "Down" || first == "Down" && second == "Right"){
                return "Down Right";
            }
            if (first == "Left" && second == "Up" || first == "Up" && second == "Left"){
                return "Up Left";
            }
            if (first == "Right" && second == "Up" || first == "Up" && second == "Right"){
                return "Up Right";
            }
            return "";
    }
}
