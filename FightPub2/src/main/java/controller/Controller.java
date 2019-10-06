package controller;

import java.awt.Rectangle;
import model.Character;
import model.MapModel;

/**
 * This class initializes the game. Contains methods to check game state.
 * @author Heidi, Pate, Joonas
 */
public class Controller {

    private Character char1;
    private Character char2;
    private int timelimit;
    private int rounds;
    private MapModel map;

    /**
     * 
     * @param char1 character that player 1 controls
     * @param char2 character that player 2 controls
     * @param map stage that characters are on
     * @param timelimit timelimit of the round in seconds
     * @param rounds number of maximum rounds
     */
    public Controller(Character char1, Character char2, MapModel map, int timelimit, int rounds) {
        this.char1 = char1;
        this.char2 = char2;
        this.map = map;
        this.timelimit = timelimit;
        this.rounds = rounds;
    }

    /**
     * Checks if the hurtboxes of the characters are intersecting. returns
     * true if characters are in collision.
     *
     * @return true if characters collide.
     */
    public boolean checkCollision() {
        Rectangle character1 = new Rectangle(char1.getxCoord(), char1.getyCoord(), char1.getHurtbox().getWidth(), char1.getHurtbox().getHeight());
        Rectangle character2 = new Rectangle(char2.getxCoord(), char2.getyCoord(), char2.getHurtbox().getWidth(), char2.getHurtbox().getHeight());
        return character1.intersects(character2);
    }

    /**
     *
     * This method checks if the hitting characters hitbox collides with 
     * the other characters hurtbox
     * 
     * @param hittingCharacter Character of player with active hitbox
     * @param characterGettingHit Character of player who might get hit
     * @return true if hitbox collides with hurtbox
     *
     */
    public boolean checkHitboxCollision(Character hittingCharacter, Character characterGettingHit) {
        
        int hitboxWidth = hittingCharacter.getHitBox().getWidth();
        int hitboxHeight = hittingCharacter.getHitBox().getHeight();
        int hitboxXcoord = hittingCharacter.getxCoord() + hittingCharacter.getHitBox().getXoffset();
        int hitboxYcoord = hittingCharacter.getyCoord();
        
        int hurtboxWidth = characterGettingHit.getHurtbox().getWidth();
        int hurtboxHeight = characterGettingHit.getHurtbox().getHeight();
        int hurtboxXcoord = characterGettingHit.getxCoord();
        int hurtboxYcoord = characterGettingHit.getyCoord();
        
        Rectangle hitbox = new Rectangle(hitboxXcoord, hitboxYcoord, hitboxWidth, hitboxHeight);
        Rectangle hurtbox = new Rectangle(hurtboxXcoord, hurtboxYcoord, hurtboxWidth, hurtboxHeight);

        return hitbox.intersects(hurtbox);
    }

    
    /**
     * Checks characters positions and makes sure they are facing eachother.
     */
    public void checkFacing() {
        if (char1.getFacing() == Character.Facing.RIGHT && char1.getxCoord() > char2.getxCoord()
                || char1.getFacing() == Character.Facing.LEFT && char1.getxCoord() < char2.getxCoord()) {
            char1.turn();
            char2.turn();
        }
    }

    public Character getCharacter1() {
        return this.char1;
    }

    public Character getCharacter2() {
        return this.char2;
    }
}
