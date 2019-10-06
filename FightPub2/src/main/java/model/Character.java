package model;

import static model.HitBox.HitLocation;

/**
 *This class contains playable character attributes and methods.
 * @see HitBox
 * @see HurtBox
 * 
 * @author Pate, Joonas
 */
public class Character {

    private int xCoord;
    private int yCoord = 20;
    private int health = 100;
    private int walkspeed;
    private String sprite;
    private String name;
    private State state;
    private Stance stance;
    private Facing facing;
    private final HurtBox hurtBox;
    private HitBox hitBox;

    
    
    /**
     * Constructor of character. 
     * @param xCoord sets the characters position in map.
     * @param facing sets the caracters direction of facing.
     */
    public Character(int xCoord, Character.Facing facing) {
        this.xCoord = xCoord;
        this.facing = facing;
        this.hurtBox = new HurtBox(20, 20);
        this.walkspeed = 4;
        this.stance = Stance.STANDING;
        this.state = State.NEUTRAL;
        this.hitBox = new HitBox(0, 0, 0, 0, 0, HitLocation.MID);
    }

    /**
     * This enum class provides the values that indicate which direction 
     * the character is facing.
     *  Character has to have a set facing value.
     * 
    */
    public enum Facing {
        RIGHT,
        LEFT
    }

    /**
     * This enum class provides the values that indicate in which state the
     * character is in.
     * If the characters state is:
     * ATTACKING: Character is locked in attack animation
     * and is unable to perform any other actions.
     * BLOCKSTUN: After successfully blocking an attack, character is in blockstun.
     * In blockstun the character is unable to perform any other actions than blocking.
     * HITSTUN: After getting hit, character is in hitstun and can not perform
     * any actions.
     * NEUTRAL: Default state for the character. Can perform most actions
     */
    
    public enum State {
        ATTACKING,
        BLOCKSTUN,
        HITSTUN,
        NEUTRAL
    }

    /**
     * This enum class provides the values that indicate if the character
     * is crouching or standing.
     * Stance affects characters hurtbox dimensions, blockable attacks and
     * enables the use of stance specific attacks.
     */
    public enum Stance {
        CROUCHING,
        STANDING
    }

    public HurtBox getHurtbox() {
        return this.hurtBox;
    }

    public Stance getStance() {
        return this.stance;
    }

    public State getState() {
        return this.state;
    }

    public Facing getFacing() {
        return this.facing;
    }

    public int getyCoord() {
        return this.yCoord;
    }

    public void setyCoord(int y) {
        this.yCoord = y;
    }

    public void setStance(Stance stance) {
        this.stance = stance;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getName() {
        return name;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }

    /**
     * Toggles characters direction of facing.
     */
    public void turn() {
        if (this.facing == Facing.LEFT) {
            this.facing = Facing.RIGHT;
        } else {
            this.facing = Facing.LEFT;
        }
    }


    /**
     * This method sets the characters hitbox values based on the switch case
     * hitbox is set to active in this process which means the character is capable of 
     * hitting the opponent
     * @param ID Tells which hit the player wants to use.
     */
    public void attack(char ID) {
        int damage;
        int xOffset;
        int yOffset;
        int width;
        int height;
        HitBox hb = this.hitBox;
        switch (ID) {
            case 'A':
                damage = 10;
                width = 10;
                height = 5;
                xOffset = 15;
                yOffset = -5;
                if (this.facing == Facing.LEFT) {
                    xOffset = this.hurtBox.getWidth() - xOffset - width;
                }
                hb.setAll(true, damage, width, height, xOffset, yOffset, HitBox.HitLocation.MID);
                break;
        }
    }
}
