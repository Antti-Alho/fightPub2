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

    public Controller(Character char1, Character char2, MapModel map, int timelimit, int rounds) {
        this.char1 = char1;
        this.char2 = char2;
        this.map = map;
        this.timelimit = timelimit;
        this.rounds = rounds;
    }

    /**
     * Checks if the hurtboxes and characters are on top of each other.
     * returns true if characters are in collision
     * 
     * @return true if boxes collide
     */
    public boolean checkHorizontalCollision() {
        if ( ( char1.getFacing() == Character.Facing.RIGHT ) && (char1.getxCoord() + char1.getHurtbox().getxOffSet() + char1.getHurtbox().getWidth() >= char2.getxCoord()) && (char1.getxCoord() + char1.getHurtbox().getxOffSet() <= char2.getxCoord() + char2.getHurtbox().getxOffSet()  + char2.getHurtbox().getWidth())) {
            return true; 
        } else if ( ( char2.getFacing() == Character.Facing.RIGHT ) && (char2.getxCoord() + char2.getHurtbox().getxOffSet() + char2.getHurtbox().getWidth() >= char1.getxCoord()) && (char2.getxCoord() + char2.getHurtbox().getxOffSet() <= char1.getxCoord() + char2.getHurtbox().getxOffSet() + char1.getHurtbox().getWidth()) )  {
            return true;
        } else return false;
    } 
    
    
    public boolean checkVerticalCollision() {
        return (char2.getHurtbox().getyOffSet() <= char1.getHurtbox().getHeight() + char1.getHurtbox().getyOffSet() &&
                char2.getHurtbox().getyOffSet() >= char1.getHurtbox().getyOffSet() || 
                char2.getHurtbox().getyOffSet() + char2.getHurtbox().getHeight() >= char1.getHurtbox().getyOffSet()); 
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

    public Character getCharacter1(){
        return this.char1;
    }
    public Character getCharacter2(){
        return this.char2;
    }
}
