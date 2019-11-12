package model;

import static model.HitBox.HitLocation;
import view.Renderer;
import javax.persistence.*;
import controller.Database;

/**
 * This class contains playable character attributes and methods.
 *
 * @see HitBox
 * @see HurtBox
 *
 * @author Pate, Joonas, Heidi, Antti
 */
@Entity
@Table(name = "Hahmo")
public class PlayerEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "standing_Width")
    private int standingWidth;

    @Column(name = "standing_Height")
    private int standingHeight;

    @Column(name = "crouching_Width")
    private int crouchingWidth;

    @Column(name = "crouching_Height")
    private int crouchingHeight;

    @Column(name = "health")
    private int health;

    @Column(name = "walkspeed")
    private int walkspeed;

    @Transient
    private HitBox hitBox;
    @Transient
    private int xCoord;
    @Transient
    private int yCoord = 0;
    @Transient
    private String sprite;
    @Transient
    private State state;
    @Transient
    private Stance stance;
    @Transient
    private Facing facing;
    @Transient
    private int stateDuration;
    @Transient
    private boolean blocking = false;
    @Transient
    private Attack attackA;

    public PlayerEntity() {
    }

    /**
     * Constructor of character.
     *
     * @param xCoord sets the characters position in map.
     * @param facing sets the characters direction of facing.
     */
    public PlayerEntity(int xCoord, PlayerEntity.Facing facing) {
        this.xCoord = xCoord;
        this.facing = facing;
        this.walkspeed = walkspeed;
        this.stance = Stance.STANDING;
        this.state = State.NEUTRAL;
        this.stateDuration = 0;

        //this.hitBox = new HitBox(0, 0, 0, 0, 0, HitLocation.MID);
    }

    /**
     * This enum class provides the values that indicate which direction the
     * character is facing. Character has to have a set facing value.
     *
     */
    public enum Facing {
        RIGHT,
        LEFT
    }

    /**
     * This enum class provides the values that indicate in which state the
     * character is in. If the characters state is: ATTACKING: Character is
     * locked in attack animation and is unable to perform any other actions.
     * BLOCKSTUN: After successfully blocking an attack, character is in
     * blockstun. In blockstun the character is unable to perform any other
     * actions than blocking. HITSTUN: After getting hit, character is in
     * hitstun and can not perform any actions. NEUTRAL: Default state for the
     * character. Can perform most actions
     */
    public enum State {
        ATTACKING,
        BLOCKSTUN,
        HITSTUN,
        NEUTRAL
    }

    /**
     * This enum class provides the values that indicate if the character is
     * crouching or standing. Stance affects characters hurtbox dimensions,
     * blockable attacks and enables the use of stance specific attacks.
     */
    public enum Stance {
        CROUCHING,
        STANDING
    }

    /**
     * Turns player facing. Is called when controller detects players swapping
     * sides in relation to each other.
     */
    public void turn() {
        if (this.facing == Facing.LEFT) {
            this.facing = Facing.RIGHT;
        } else {
            this.facing = Facing.LEFT;
        }
    }

    /**
     * sets hitbox in a position determined by ID.
     *
     * @param ID char value that indicates attack used.
     */
    public void attack(char ID) {
        switch (ID) {
            case 'A':
                attackA.setTimer(0);
                if (attackA.getActivationTime() == attackA.getTimer()) {
                    attackA.setHitBox();
                }
        }
    }


    public int getHeight(){
        if (stance == Stance.CROUCHING){
            return this.crouchingHeight;
        }
        else if (stance == Stance.STANDING) {
            return this.standingHeight;
        }
        return this.standingHeight;
    }

    public void setAttackTimer() {
        attackA.setTimer(attackA.getTimer() + 1);
        attackA.setTimer(attackA.getTimer() + 1);
        attackA.setTimer(attackA.getTimer() + 1);
        attackA.setTimer(attackA.getTimer() + 1);
    }

    public HurtBox getHurtbox() {
        return this.hurtBox;
    }
    
    public int getWidth(){
        if (stance == Stance.CROUCHING){
        return this.crouchingWidth;
        }
        else if (stance == Stance.STANDING) {
            return this.standingWidth;
        }
        return this.standingWidth;
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

    public int getStateDuration() {
        return stateDuration;
    }

    public void setStateDuration(int stateDuration) {
        this.stateDuration = stateDuration;
    }

    public void setyCoord(int y) {
        this.yCoord = y;
    }

    public void setStance(Stance stance) {
        this.stance = stance;
    }

    public boolean isBlocking() {
        return blocking;
    }

    public void setBlocking(boolean isBlocking) {
        this.blocking = isBlocking;
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

    public void setName(String name) {
        this.name = name;
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
     * @return the standingWidth
     */
    public int getStandingWidth() {
        return standingWidth;
    }

    /**
     * @param standingWidth the standingWidth to set
     */
    public void setStandingWidth(int standingWidth) {
        this.standingWidth = standingWidth;
    }

    /**
     * @return the standingHeight
     */
    public int getStandingHeight() {
        return standingHeight;
    }

    /**
     * @param standingHeight the standingHeight to set
     */
    public void setStandingHeight(int standingHeight) {
        this.standingHeight = standingHeight;
    }

    /**
     * @return the crouchingWidth
     */
    public int getCrouchingWidth() {
        return crouchingWidth;
    }

    /**
     * @param crouchingWidth the crouchingWidth to set
     */
    public void setCrouchingWidth(int crouchingWidth) {
        this.crouchingWidth = crouchingWidth;
    }

    /**
     * @return the crouchingHeight
     */
    public int getCrouchingHeight() {
        return crouchingHeight;
    }

    /**
     * @param crouchingHeight the crouchingHeight to set
     */
    public void setCrouchingHeight(int crouchingHeight) {
        this.crouchingHeight = crouchingHeight;
    }

    /**
     * @return the walkspeed
     */
    public int getWalkspeed() {
        return walkspeed;
    }

    /**
     * @param walkspeed the walkspeed to set
     */
    public void setWalkspeed(int walkspeed) {
        this.walkspeed = walkspeed;
    }

    public Attack getAttackA() {
        return attackA;
    }

    public void setAttackA(Attack attackA) {
        this.attackA = attackA;
    }

}
