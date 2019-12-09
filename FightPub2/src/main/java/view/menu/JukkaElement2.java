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

import view.View;

/**
 *
 * @author Joonas
 */
public class JukkaElement2 extends MenuElement {
    String char1;
    private String label;
    public JukkaElement2(String char1) {
        this.label = texts.getString("CHAR2"); 
        this.char1 = char1;
    }
    
    @Override
    public void action() {
        View view = new View(this.char1, "Jukka"); // Poistetaan myöhemmin viittaukset pekkaan ja jukkaan.
        view.run();
    }
    @Override
    public String getLabel() {
        return this.label;
    }
}
