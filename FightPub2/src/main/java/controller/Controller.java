package controller;

import Model.Character;
import Model.MapModel;


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

    public Controller() {
        this.char1 = new Character(true, "Jukka");
        this.char2 = new Character(false, "Pekka");
    }

    public Controller(String char1Name, String char2Name, MapModel map, int timelimit, int rounds) {
        this.char1 = new Character(true, char1Name);
        this.char2 = new Character(false, char2Name);
        this.map = map;
        this.timelimit = timelimit;
        this.rounds = rounds;

    }

    /**
     * @param character
     * @return the character
     */
    public Character getCharacter(int character) {
        if (character == 1) {
            return this.char1;
        }
        if (character == 2) {
            return this.char2;
        }
        return null;
    }

    /**
     * Checks if the hurtboxes and characters are on top of each other.
     * returns true if characters are in collision
     * 
     * @return
     */
    //Time to figure out in what function we change the facing direction of the character. My suggestion:
    //Check char1 and char 2 xCoord before drawing every frame. 
    // If ( Controller.getCharacter(1).getXCoord < Controller.getCharacter(2).getXcoord  && 
    // Controller.getCharacter(1).getFacing != Character.getFacingRightEnum )  {
    // Controller.getCharacter(1).setFacing(RIGHT)
    // } and so on... I want to check if chatacter allready is facing the direction he should be facing so we dont execute the setting for no good reason.
    //this is why i have this line in the if statement: && 
    // Controller.getCharacter(1).getFacing != Character.getFacingRightEnum ) 
    
    public boolean checkCollision() {
        if ( ( char1.getFacing() == Character.getFacingRightEnum() ) && (char1.getxCoord() + char1.getHurtbox().getxOffSet() == char2.getxCoord()) ) {
            return true; 
        } else if ( ( char2.getFacing() == Character.getFacingRightEnum() ) && (char2.getxCoord() + char2.getHurtbox().getxOffSet() == char1.getxCoord()) ) {
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
}
