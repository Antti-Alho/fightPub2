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
package view;

import model.MenuElement;

/**
 *
 * @author flatline
 */
public class Character1Menu extends CLIMenu {
    public Character1Menu() {
        super.menuelements.clear();
        super.menuelements.add(new MenuElement(super.texts.getString("CHAR1")));
        super.menuelements.add(new MenuElement(super.texts.getString("CHAR2")));
        super.menuelements.add(new MenuElement(super.texts.getString("CHAR3")));
        super.menuelements.add(new MenuElement(super.texts.getString("CHAR4")));
        super.menuelements.add(new MenuElement(super.texts.getString("BACK")));
        super.showMenu();
    }
    
}
