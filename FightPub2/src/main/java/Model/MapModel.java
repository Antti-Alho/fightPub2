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
