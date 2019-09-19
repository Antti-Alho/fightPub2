package model;


/**
 *
 * @author flatline
 */
import javax.swing.JFrame;

public class MenuElement {
    
    public boolean active;
    public String label;
    
   public MenuElement(String label ) {
       this.active = false;
       this.label=label;
   }
    
}
