
package view.menu;

import view.menu.MenuIF;

/**
 * Menu Element to enter character selection
 * @author Joonas
 */
public class PlayElement extends MenuElement{ 
    public PlayElement() {
        super.label = super.texts.getString("PLAY");
        
    }
    @Override
    public void action() {
        MenuIF menu = new Character1Menu();
    }


}
