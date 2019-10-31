/*
 * Copyright (C) 2019 Pate
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
package model;

import controller.Controller;

/**
 *
 * @author Pate
 */
public class NewClass {

    public static void main(String[] args) {
        InitDatabase init = new InitDatabase();
        Controller acontroller = new Controller("Pekka", "Pekka", new MapModel("Kaisla"), 99, 2);
        PlayerEntity seppo;


        seppo = acontroller.getCharacter1();
        int duration = seppo.getStateDuration();
        System.out.println(duration);
        if (seppo.crouchA == null) {
            System.out.println("nulli o");
        }

        int damageSeppo = seppo.crouchA.get("damage");

        System.out.println(damageSeppo);

    }
}
