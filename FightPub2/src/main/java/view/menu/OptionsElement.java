
package view.menu;

/**
 * Menu element to go to options menu.
 * @author Joonas
 */
public class OptionsElement extends MenuElement {
    
    
    public OptionsElement() {
        super.label = super.texts.getString("OPTIONS");
    }
    @Override
    public void action() {
        MenuIF menu = new OptionsMenu();
    }

}
