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

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Pate
 */
public class MapModel {
    
    public MapModel () {
        
    HashMap<String, List<Integer>> mapLines = new HashMap<>();
    
    // (X1, Y1, X2, Y2)
    final Integer[] bottomOfMap = { 0, 0, 3000, 0};
    final Integer[] rightOfMap = {3000, 0, 3000, 1920};
    final Integer[] topOfMap = {3000, 1920, 0, 1920};
    final Integer[] leftOfMap = {0, 1920, 0, 0};
    
    mapLines.put("bottom", Arrays.asList(bottomOfMap));
    mapLines.put("right", Arrays.asList(rightOfMap));
    mapLines.put("top", Arrays.asList(topOfMap));
    mapLines.put("left", Arrays.asList(leftOfMap));
              
    }

}
