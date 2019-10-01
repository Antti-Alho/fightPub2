package controller;

import java.awt.Rectangle;
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
     * Checks if the hurtboxes of characters are on top of each other.
     * returns true if characters are in collision
     * 
     * @return true if boxes collide
     */
    public boolean checkCollision(){        
        Rectangle character1 = new Rectangle(char1.getxCoord(), char1.getyCoord() ,char1.getHurtbox().getWidth(), char1.getHurtbox().getHeight());
        Rectangle character2 = new Rectangle(char2.getxCoord(), char2.getyCoord() ,char2.getHurtbox().getWidth(), char2.getHurtbox().getHeight());
        return character1.intersects(character2);
    }
/**
 * 
 * @param hittingCharacter Character of player with active hitbox
 * @param characterGettingHit Character of player who might get hit
 * @return true if hitbox collides with hurtbox
 * 
 */
    public boolean checkHitboxCollision(Character hittingCharacter, Character characterGettingHit) {
        int hitboxWidth = hittingCharacter.getHitBox().getWidth();
        int hitboxHeight = hittingCharacter.getHitBox().getHeight();
        int hurtboxWidth = characterGettingHit.getHurtbox().getWidth();
        int hurtboxHeight = characterGettingHit.getHurtbox().getHeight();
        
        Rectangle hitbox = new Rectangle(hittingCharacter.getxCoord() + hittingCharacter.getHitBox().getXoffset(), hittingCharacter.getyCoord(), hitboxWidth, hitboxHeight);
        Rectangle hurtbox = new Rectangle(characterGettingHit.getxCoord(), characterGettingHit.getyCoord() ,hurtboxWidth, hurtboxHeight);
        System.out.println(hitbox.x + "hitbox vasen reuna");
        return hitbox.intersects(hurtbox);
    }
    /**
     * Checks if characters have switched sides, and turns them to face each
     * other again
     */
    public void checkFacing() {
        if (char1.getFacing() == Character.Facing.RIGHT && char1.getxCoord() > char2.getxCoord() ||
                char1.getFacing() == Character.Facing.LEFT && char1.getxCoord() < char2.getxCoord()) {
            char1.turn();
            char2.turn();
        }
    }


    public Character getCharacter1(){
        return this.char1;
    }
    public Character getCharacter2(){
        return this.char2;
    }
}
