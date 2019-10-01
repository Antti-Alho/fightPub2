package model;

import static model.HitBox.HitLocation;

/**
 *
 * @author Pate, Joonas
 */

public class Character {


    private int xCoord;
    private int yCoord = 20;
    private int health = 100;
    private int walkspeed;
    private boolean player1 = false;
    private String sprite;
    private String name;
    private State state;
    private Stance stance;
    private Facing facing;
    private HurtBox hurtBox;
    private HitBox hitBox;  

    /**
     * 
     * @param player1 boolean is true if character is controlled by player 1
     * sets character to left side of screen on round start.
     * @param name Name of character.
     */
    public Character (boolean player1, String name) {
        if (player1 == true) {
           this.xCoord = 1200;
           this.facing = Facing.RIGHT;
           this.hurtBox = new HurtBox( 20, 20);
        } else {
           this.xCoord = 1800;
           this.facing=Facing.LEFT;
           this.hurtBox = new HurtBox(20, 20);
        }
        this.walkspeed = 4;
        this.stance = Stance.STANDING;
        this.state = State.NEUTRAL;

        this.hitBox = new HitBox(0, 0, 0, 0, 0, HitLocation.MID);
        

    }

    public enum Facing {
        RIGHT,
        LEFT
    }

    public enum State {
        ATTACKING,
        BLOCKSTUN,
        HITSTUN,
        NEUTRAL
    }
    
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

    public boolean isPlayer() {
        return player1;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }
    /**
     * Turns player facing. Is called when controller detects players swapping
     * sides in relation to each other.
     */
    public void turn() {
        if (this.facing == Facing.LEFT) {
            this.facing = Facing.RIGHT;
        }
        else {
            this.facing = Facing.LEFT;
        }
    }
    
    /**
     * sets hitbox in a position determined by ID.
     * @param ID char value that indicates attack used.
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
                hb.setAll(true, damage, width, height, xOffset, yOffset);
                break;    
        }
    }
}
