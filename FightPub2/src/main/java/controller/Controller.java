package controller;

import model.Character;
import model.MapModel;


/**
 *
 * @author Heidi, Pate
 */
public class Controller {

    private Character char1;
    private Character char2;
    private int timelimit;
    private int rounds;
    private MapModel map;

    public Controller(Character char1, Character char , MapModel map, int timelimit, int rounds) {
        this.char1 = new Character(true, char1Name);
        this.char2 = new Character(false, char2Name);
        this.map = map;
        this.timelimit = timelimit;
        this.rounds = rounds;

    }

    /**
     * Checks if the hurtboxes and characters are on top of each other.
     * returns true if characters are in collision
     * 
     * @return
     */
    public boolean checkCollision() {
        if ( ( char1.getFacing() == Character.Facing.RIGHT ) && (char1.getxCoord() + char1.getHurtbox().getxOffSet() == char2.getxCoord()) ) {
            return true; 
        } else if ( ( char2.getFacing() == Character.Facing.RIGHT ) && (char2.getxCoord() + char2.getHurtbox().getxOffSet() == char1.getxCoord()) ) {
            return true;
        } else return false;
    } 

    public boolean checkHitboxCollision() {
        if (true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkHurtboxCollision() {
        if (true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Listens inputs.
     */
    public void eventListener() {

    }

    public void checkNextFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void advance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Listens if there have been keyboard commands.
     */
    /*
    public checkInputs(){
        return ;
    }
     */
    
    public Character getCharacter1(){
        return this.char1;
    }
    public Character getCharacter2(){
        return this.char2;
    }
}
