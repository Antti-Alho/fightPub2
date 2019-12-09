
package view.menu;

/**
 * In this menu, Player 2 chooses character. It is called with String parameter
 * that is got from Character1Menu. It then passes both characters as String
 * to instantiate View class object.
 * @author Joonas
 */
public class Character2Menu extends CLIMenu {
    String char1;
    String char2;
    public Character2Menu(String char1) {
        this.char1 = char1;
        menuelements.clear();
        menuelements.add(new JukkaElement2(char1));
        menuelements.add(new PekkaElement2(char1));
        showMenu();
        activateMenuElement();
    }
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
                menu = new CLIMainMenu();
                break;
            default:
                break;
        }
    }
    
}
