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

import controller.Controller;
import java.util.HashMap;
import java.util.Map;
import model.MapModel;

/**
 *
 * @author antti
 */
public class StateMachine implements State {

    private final Map<String, State> states;
    private State currentState;

    public StateMachine() {
        states = new HashMap<>();
        currentState = new EmptyState();
        states.put(null, currentState);
    }

    /**
     * Adds a state to state machine.
     * @param name  Name of state
     * @param state The state to add
     */
    public void add(String name, State state) {
        states.put(name, state);
    }

    /**
     * Changes the current state.
     * @param name Name of new state
     */
    public void change(String name) {
        currentState.exit();
        currentState = states.get(name);
        currentState.enter();
    }

    @Override
    public void input() {
        currentState.input();
    }

    @Override
    public void update() {
        currentState.update();
    }

    @Override
    public void render() {
        currentState.render();
    }

    @Override
    public void enter() {
        currentState.enter();
    }

    @Override
    public void exit() {
        currentState.exit();
    }

}
