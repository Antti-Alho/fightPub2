/*
 * Copyright (C) 2019 Joonas
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

/**
 *
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
