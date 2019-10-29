package model;

import static model.HitBox.HitLocation;
import view.Renderer;
import javax.persistence.*;
import controller.Database;
import java.util.HashMap;
import java.util.Map;

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
    private HurtBox hurtBox;
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
    Map<String,Integer> crouchA;

    

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
        this.hurtBox = new HurtBox(getStandingHeight(), getStandingWidth());
        this.walkspeed = 4;
        this.stance = Stance.STANDING;
        this.state = State.NEUTRAL;
        this.stateDuration = 0;
        crouchA = new HashMap<String, Integer>();
        //this.hitBox = new HitBox(0, 0, 0, 0, 0, HitLocation.MID);
        crouchA.put("damage", 10);
        crouchA.put("xOffset", 0);
        crouchA.put("yOffset", 200);
        crouchA.put("width", 100);
        crouchA.put("height", 100);
        crouchA.put("hitStun", 10);
        crouchA.put("blockStun", 10);
        
        
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
        int lol;
        if (this.facing == Facing.LEFT) {
            this.facing = Facing.RIGHT;
            lol = this.crouchA.get("damage");
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
        int xOffset;

        HitBox hb = this.hitBox;
        switch (ID) {
            case 'A':
                
                xOffset = this.crouchA.get("xOffset");
                System.out.println(xOffset);


                if (this.facing == Facing.LEFT) {
                    xOffset = this.hurtBox.getWidth() - this.crouchA.get("xOffset") - this.crouchA.get("width");
                }
                hb.setAll(this.crouchA.get("damage"), this.crouchA.get("width"),
                this.crouchA.get("height"), xOffset, this.crouchA.get("yOffset"),
                this.crouchA.get("hitStun"), this.crouchA.get("blockStun"), HitBox.HitLocation.LOW);
                break;
        }
    }

    public HurtBox getHurtbox() {
        return this.hurtBox;
    }

    public void setHurtBox(HurtBox hurtBox) {
        this.hurtBox = hurtBox;
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

}
