package Model;

/**
 *
 * @author Pate
 */
public class Character {
    
    public int xCoord;
    public int health = 100;
    boolean player1 = false;
    boolean facingRight = false;
    boolean STATE_HITSTUN = false, STATE_ATTACK = false, STATE_BLOCKSTUN = false;
    String sprite, name = "eman";
        
    HurtBox hurtBox = new HurtBox();
    
    public Character (boolean player1, String name) {
       if (player1 == true) {
           xCoord = 1200;
           facingRight = true;
       } else {
           xCoord = 1800;
           facingRight = false;
       }
       this.player1 = player1;
       this.name = name;
       hurtBox.setXcoord(xCoord);
        
    }
    
   
    public void changeFacing () {
        //changes the facingRight boolean to the correct value.
        
    } 
    
    public void move(int A) {
        //changes the location of character
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

    public boolean isPlayer1() {
        return player1;
    }

    public void setPlayer1(boolean player1) {
        this.player1 = player1;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public boolean isSTATE_HITSTUN() {
        return STATE_HITSTUN;
    }

    public void setSTATE_HITSTUN(boolean STATE_HITSTUN) {
        this.STATE_HITSTUN = STATE_HITSTUN;
    }

    public boolean isSTATE_ATTACK() {
        return STATE_ATTACK;
    }

    public void setSTATE_ATTACK(boolean STATE_ATTACK) {
        this.STATE_ATTACK = STATE_ATTACK;
    }

    public boolean isSTATE_BLOCKSTUN() {
        return STATE_BLOCKSTUN;
    }

    public void setSTATE_BLOCKSTUN(boolean STATE_BLOCKSTUN) {
        this.STATE_BLOCKSTUN = STATE_BLOCKSTUN;
    }
    
    
    
    
}