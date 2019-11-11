/*
 * Copyright (C) 2019 antti
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

/**
 * You only exit and forget that this state ever existed.
 * used as a default state for state machine.
 * @author antti
 */
public class EmptyState implements State{

    @Override
    public void input() {
        throw new UnsupportedOperationException("Tried to call Empty state."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Tried to call Empty state."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Tried to call Empty state."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enter() {};

    @Override
    public void exit() {};
    
}
