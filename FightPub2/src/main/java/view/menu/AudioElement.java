
package view.menu;

/**
 * MenuElement that launches audio options menu.
 *
 * @author Joonas
 */
public class AudioElement extends MenuElement {

    private String label;
    
    public AudioElement() {
        this.label = texts.getString("AUDIO");
    }
    @Override
    public void action() {
        System.out.println("Not yet Implemented");
    }
    @Override
    public String getLabel() {
        return this.label;
    }
    
}
