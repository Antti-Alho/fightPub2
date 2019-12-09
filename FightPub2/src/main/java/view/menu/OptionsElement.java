
package view.menu;

/**
 * Menu element to go to options menu.
 * @author Joonas
 */
public class OptionsElement extends MenuElement {
    private String label;
    
    public OptionsElement() {
        this.label = super.texts.getString("OPTIONS");
    }
    @Override
    public void action() {
        MenuIF menu = new OptionsMenu();
    }
    @Override
    public String getLabel() {
        return this.label;
    }
}
