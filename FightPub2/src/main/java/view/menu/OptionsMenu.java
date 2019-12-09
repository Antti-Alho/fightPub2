
package view.menu;



/**
 * Menu to show game options.
 * @author flatline
 */
public class OptionsMenu extends CLIMenu {
    public OptionsMenu() {
        menuelements.clear();
        menuelements.add(new ControlsElement());
        menuelements.add(new VideoElement());
        menuelements.add(new AudioElement());
        menuelements.add(new MainMenuElement());
    }
    @Override
    public void activateMenuElement() {
        switch (input.nextInt()) {
            case 1:
                    System.out.println("No options");
                    super.showMenu();
                    break;
            case 2:
                 System.out.println("No options");
                    super.showMenu();
                    break;
            case 3:
                System.out.println("No options");
                    super.showMenu();
                    break;
            case 4:
                super.menu = new CLIMainMenu();
        }
    }
}
