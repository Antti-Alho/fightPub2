package Model;

/**
 *
 * @author Pate
 */
enum Stance {
    CROUCHING,
    STANDING
}
enum State {
    ATTACKING,
    BLOCKSTUN,
    HITSTUN,
    NEUTRAL
}
enum Facing {
    RIGHT,
    LEFT
}
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
       } else {
           xCoord = 1800;
           this.facing=Facing.LEFT;
       }
       this.walkspeed = 4;
       this.stance = Stance.STANDING;
       this.state = State.NEUTRAL;
    }


    public void changeFacing () {
        //changes the facingRight boolean to the correct value.

    }

    public void walk(String direction) {
        //changes the location of character
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

    public Object getFacingRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNextLocation(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
