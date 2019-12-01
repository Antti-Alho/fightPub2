
package model;

import view.Character1Menu;
import view.MenuIF;

/**
 * Menu Element to enter character selection
 * @author Joonas
 */
public class PlayElement extends MenuElement{
    String label; 
    MenuIF menu; 
    public PlayElement() {
        this.label = texts.getString("PLAY");
        this.menu = new Character1Menu();
    }
    @Override
    public void action() {
        menu.showMenu();
    }
}
