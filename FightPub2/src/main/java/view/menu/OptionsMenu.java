/*
 * Copyright (C) 2019 flatline
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package view.menu;

import view.menu.CLIMenu;
import view.menu.CLIMainMenu;
import view.menu.MenuElement;

/**
 *
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
