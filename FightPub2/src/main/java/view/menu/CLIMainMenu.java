
package view.menu;

/**
 * Menu that is spawned on program startup.
 * @author Joonas
 */
public class CLIMainMenu extends CLIMenu {
    public CLIMainMenu() {
        this.menuelements.clear();
        this.menuelements.add(new PlayElement());
        this.menuelements.add(new OptionsElement());
        
        this.showMenu();
        activateMenuElement();
    }
    
    /**
     * Selects menu action.
     */
    @Override
    public void activateMenuElement() {
        switch (input.nextInt()) {
            case 1:
                    menuelements.get(0).action();
                    break;
            case 2:
                    menuelements.get(1).action();
                break;
            case 3:
                System.exit(0);
        }
    }
}
