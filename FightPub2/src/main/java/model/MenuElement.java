package model;


/**
 * Single menu element. The active active attribute describes if the element is selected
 * in UI.
 * @author Joonas, Patrik
 */


public class MenuElement {
    
    public boolean active;
    public String label;
    
    /**
     * 
     * @param label is the name of the element 
     */
   public MenuElement(String label) {
       this.active = false;
       this.label=label;
   }
    
   
   
}
