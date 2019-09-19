package model;
import static model.Character.Facing;
/**
 *
 * @author Pate
 */

public class Character {


    private int xCoord;
    private int yCoord = 0;
    private int health = 100;
    private int walkspeed;
    private boolean player1 = false;
    private String sprite;
    private String name;
    private State state;
    private Stance stance;
    private Facing facing;
    private HurtBox hurtBox;

    public Character (boolean player1, String name) {
        if (player1 == true) {
           this.xCoord = 1200;
           this.facing = Facing.RIGHT;
           this.hurtBox = new HurtBox(this.xCoord, 20, 20, 20, 0, this);
        } else {
           this.xCoord = 1800;
           this.facing=Facing.LEFT;
           this.hurtBox = new HurtBox(this.xCoord, 20, 20, 20, 0, this);
           
        }
        this.walkspeed = 4;
        this.stance = Stance.STANDING;
        this.state = State.NEUTRAL;
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

    /**
     * 
     */
    public void changeFacing () {
        

    }
    
    /**
     * 
     * @return 
     */
    public HurtBox getHurtbox() {
        return this.hurtBox;
    }

    /**
     * 
     * @param direction 
     */
    public void walk(String direction) {
        
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

    public short getNextxCoord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setLocation(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void setNextLocation(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object getFacingRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
