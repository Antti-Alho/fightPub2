/*
 * Copyright (C) 2019 Heidi
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
package fightpub2;
 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
import javax.swing.JFrame;
import javax.swing.JTextField;
 
public class KeyListenerExample {
 
    public static void main(String args[]) {

        JFrame frame = new JFrame("Key Listener");

        Container contentPane = frame.getContentPane();

        KeyListener listener = new KeyListener() {

            @Override

            public void keyPressed(KeyEvent event) {

                printEventInfo("Key Pressed", event);

            }

            @Override

            public void keyReleased(KeyEvent event) {

                printEventInfo("Key Released", event);

            }

            @Override

            public void keyTyped(KeyEvent event) {

                printEventInfo("Key Typed", event);

            }

            private void printEventInfo(String str, KeyEvent e) {

                System.out.println(str);

                int code = e.getKeyCode();

                System.out.println("   Code: " + KeyEvent.getKeyText(code));

                System.out.println("   Char: " + e.getKeyChar());

                int mods = e.getModifiersEx();

                System.out.println("    Mods: "

                + KeyEvent.getModifiersExText(mods));

                System.out.println("    Location: "

                + keyboardLocation(e.getKeyLocation()));

                System.out.println("    Action? " + e.isActionKey());

            }

            private String keyboardLocation(int keybrd) {

                switch (keybrd) {

                case KeyEvent.KEY_LOCATION_RIGHT:

                return "Right";

                case KeyEvent.KEY_LOCATION_LEFT:

                return "Left";

                case KeyEvent.KEY_LOCATION_NUMPAD:

                return "NumPad";

                case KeyEvent.KEY_LOCATION_STANDARD:

                return "Standard";

                case KeyEvent.KEY_LOCATION_UNKNOWN:

                default:

                return "Unknown";

                }

            }

        };

        JTextField textField = new JTextField();

        textField.addKeyListener(listener);

        contentPane.add(textField, BorderLayout.NORTH);

        frame.pack();

        frame.setVisible(true);
    }
}