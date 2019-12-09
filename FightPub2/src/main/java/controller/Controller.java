package controller;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.IntBuffer;
import model.PlayerEntity;
import model.MapModel;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.opengl.GL11.glClearColor;
import org.lwjgl.system.MemoryStack;
import controller.Database;
import model.Attack;
import model.HitBox;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwGetKey;

/**
 * This class initializes the game. Contains methods to check game state.
 *
 * @author Heidi, Pate, Joonas, Antti
 */
public class Controller {

    private PlayerEntity char1;
    private PlayerEntity char2;
    private int timelimit;
    private int rounds;
    private MapModel map;
    private view.Texture texture;
    private KeyEvent keyCallback;
    private KeyListener listener;
    private InputBuffer inputB;
    private String player1Save = "";
    private String player2Save = "";
    private Moves moves2= new Moves(this);
    private Moves moves1= new Moves(this);
    boolean dead1 = false;
    boolean dead2 = false;
    

    /**
     *
     * @param char1 character that player 1 controls
     * @param char2 character that player 2 controls
     * @param map stage that characters are on
     * @param timelimit timelimit of the round in seconds
     * @param rounds number of maximum rounds
     */
    public Controller(String char1, String char2, MapModel map, int timelimit, int rounds) {
        Database db = new Database();
        this.char1 = db.getPlayerEntity(char1);
        this.char1.setFacing(PlayerEntity.Facing.RIGHT);
        this.char1.setStance(PlayerEntity.Stance.STANDING);
        this.char1.setState(PlayerEntity.State.NEUTRAL);
        this.char1.setStateDuration(40);
        this.char2 = db.getPlayerEntity(char2);
        this.char2.setFacing(PlayerEntity.Facing.LEFT);
        this.char2.setStance(PlayerEntity.Stance.STANDING);
        this.char2.setState(PlayerEntity.State.NEUTRAL);
        this.char2.setStateDuration(40);
        this.char1.setxCoord(480);
        this.char2.setxCoord(1200);
        this.char1.setHitBox(new HitBox(0, 0, 0, 0, 0, HitBox.HitLocation.HIGH));
        this.char2.setHitBox(new HitBox(0, 0, 0, 0, 0, HitBox.HitLocation.HIGH));
        this.char1.setAttackA(new Attack(10, 200, 100, 150, 201, 50, 50, 20, 20, HitBox.HitLocation.LOW, this.char1));
        this.char2.setAttackA(new Attack(10, 200, 100, 150, 201, 50, 50, 20, 20, HitBox.HitLocation.LOW, this.char2));
        this.map = map;
        this.timelimit = timelimit;
        this.rounds = rounds;
        this.inputB = new InputBuffer();
    }

    /**
     * Checks if the hurtboxes of the characters are intersecting. returns true
     * if characters are in collision.
     *
     * @return true if characters collide.
     */
    public boolean checkCollision() {
        Rectangle character1 = new Rectangle(char1.getxCoord(), char1.getyCoord(), char1.getWidth(), char1.getHeight());
        Rectangle character2 = new Rectangle(char2.getxCoord(), char2.getyCoord(), char2.getWidth(), char2.getHeight());
        return character1.intersects(character2);
    }
    public boolean checkCornerLeft(PlayerEntity chara){
        return (chara.getxCoord() <= map.LEFTBORDER);
    }
     public boolean checkCornerRight(PlayerEntity chara){
        return (chara.getxCoord()+chara.getWidth()>= map.RIGHTBORDER); 

    }

    /**
     * Checks if the hitting characters hitbox collides with the other
     * characters hurtbox
     *
     * @param hittingCharacter Character of player with active hitbox
     * @param characterGettingHit Character of player who might get hit
     * @return true if hitbox collides with hurtbox
     */
    public boolean checkHitboxCollision(PlayerEntity hittingCharacter, PlayerEntity characterGettingHit) {

        int hitboxWidth = hittingCharacter.getHitBox().getWidth();
        int hitboxHeight = hittingCharacter.getHitBox().getHeight();
        int hitboxXcoord = hittingCharacter.getxCoord() + hittingCharacter.getHitBox().getXoffset();
        int hitboxYcoord = hittingCharacter.getyCoord() + hittingCharacter.getHitBox().getYoffset();

        int hurtboxWidth = characterGettingHit.getWidth();
        int hurtboxHeight = characterGettingHit.getHeight();
        int hurtboxXcoord = characterGettingHit.getxCoord();
        int hurtboxYcoord = characterGettingHit.getyCoord();

        Rectangle hitbox = new Rectangle(hitboxXcoord, hitboxYcoord, hitboxWidth, hitboxHeight);
        Rectangle hurtbox = new Rectangle(hurtboxXcoord, hurtboxYcoord, hurtboxWidth, hurtboxHeight);
        return hitbox.intersects(hurtbox);
    }

    /**
     * call checker methods here in correct order in the end of every update
     * function call.
     */
    public void masterCheck() {
        checkFacing();
        hitter();
        reduceStateDuration();
        healthCheck();
    }

    /**
     *
     * @param char1 Hitting character
     * @param char2 Character getting hit
     * @return true if hit gets blocked, else return false
     */
    public boolean isHitBlocked(PlayerEntity char1, PlayerEntity char2) {
        boolean blocking = char2.isBlocking(); //placeholder boolean for input. implemented later
        if (char2.getState() != PlayerEntity.State.NEUTRAL && char2.getState() != PlayerEntity.State.BLOCKSTUN) {
            blocking = false;
        }

        if (blocking == false) {
            return false;
        }
        if (char2.getStance() == PlayerEntity.Stance.CROUCHING && char1.getHitBox().getHitLocation() == HitBox.HitLocation.HIGH
                || char2.getStance() == PlayerEntity.Stance.STANDING && char1.getHitBox().getHitLocation() == HitBox.HitLocation.LOW) {
            return false;
        }
        return true;
    }

    /**
     * Sets the hitstun variable of the character getting hit.
     *
     * @param character PlayerEntity that is getting hit.
     * @param stunDuration the amount of time in frames that the PlayerEntity
     * will be in hitstun
     * @param state that will be set.
     */
    public void setStun(PlayerEntity character, int stunDuration, PlayerEntity.State state) {
        character.setState(state);
        character.setStateDuration(stunDuration);
    }

    /**
     * Checks if the checkHitBoxCollision is true in both cases. Cases being
     * where the char1/char2 is the hittingCharacter and char1/char2 is the
     * characterGettingHit. if hitBoxCollision is true set the stateDuration of
     * the characterGettingHit.
     */
    public void hitter() {
        //Character 2 not blocking
        if (checkHitboxCollision(char1, char2) && !isHitBlocked(char1, char2)) {
            //if player 2 in attacking state and player 1 hits player 2 , player 2 takes more dmg
            if (char2.getState() == PlayerEntity.State.ATTACKING) {
                double dmgCalculation = (double) char2.getHealth() - (double) char1.getHitBox().getDamage() * 1.2;
                char2.setHealth((int) dmgCalculation);
            } else {
                char2.setHealth(char2.getHealth() - char1.getHitBox().getDamage());
            }
            setStun(char2, char1.getHitBox().getHitStun(), PlayerEntity.State.HITSTUN);
            char1.getHitBox().deactivate(); // deactivates hitBox
            //Blocking
        } else if (checkHitboxCollision(char1, char2) && isHitBlocked(char1, char2)) {
            setStun(char2, char1.getHitBox().getBlockStun(), PlayerEntity.State.BLOCKSTUN);
            char1.getHitBox().deactivate(); // deactivates hitBox
        }

        //Character 1 not blocking
        if (checkHitboxCollision(char2, char1) && !isHitBlocked(char2, char1)) {
            if (char1.getState() == PlayerEntity.State.ATTACKING) {
                double dmgCalculation2 = (double) char1.getHealth() - (double) char2.getHitBox().getDamage() * 1.2;
                char1.setHealth((int) dmgCalculation2);
            } else {
                char1.setHealth(char1.getHealth() - char2.getHitBox().getDamage());
            }
            setStun(char1, char2.getHitBox().getHitStun(), PlayerEntity.State.HITSTUN);
            char2.getHitBox().deactivate(); // deactivates hitBox
            //Blocking
        } else if (checkHitboxCollision(char2, char1) && isHitBlocked(char2, char1)) {
            setStun(char1, char2.getHitBox().getBlockStun(), PlayerEntity.State.BLOCKSTUN);
            char2.getHitBox().deactivate(); // deactivates hitBox
        }
    }

    /**
     * If playerEntity stateDuration is 0 set playerEntity state to neutral else
     * reduce stateDuration by 1.
     *
     */
    
    public void reduceStateDuration() {
        if (char1.getStateDuration() == 0 && char1.getState() != PlayerEntity.State.NEUTRAL) {
            char1.setState(PlayerEntity.State.NEUTRAL);
        } else {
            char1.setStateDuration(char1.getStateDuration() - 1);
        }
        if (char2.getStateDuration() == 0 && char2.getState() != PlayerEntity.State.NEUTRAL) {
            char2.setState(PlayerEntity.State.NEUTRAL);
        } else {
            char2.setStateDuration(char2.getStateDuration() - 1);

        }
    }
    
    /**
     * Checks characters positions and makes sure they are facing eachother.
     */
    public void checkFacing() {
        if (char1.getFacing() == PlayerEntity.Facing.RIGHT && char1.getxCoord()+char1.getWidth()/2 > char2.getxCoord()+ char2.getWidth()/2
                || char1.getFacing() == PlayerEntity.Facing.LEFT && char1.getxCoord()+char1.getWidth()/2 < char2.getxCoord()+char2.getWidth()/2) {
            char1.turn();
            char2.turn();
        }
    }

    public PlayerEntity getCharacter1() {
        return this.char1;
    }

    public PlayerEntity getCharacter2() {
        return this.char2;
    }

    /**
     * Updates players positions.
     */
    public void update() {
        char1.getAttackA().updateHitbox();
        char2.getAttackA().updateHitbox();

        String player1Move = "";
        String player2Move = "";
        
        String[] list1=null;
        String[] list2=null;
        try {
            player1Move = inputB.player1GetMove(); 
        } catch (Exception e) {}
        try {
            player2Move = inputB.player2GetMove();
        } catch (Exception e) {}
        masterCheck();
        //Gives information to getMove-method and gets updated ones back
        list1 = moves1.getMove(char1, char2, player1Move, player1Save);
        list2 = moves2.getMove(char2, char1, player2Move, player2Save);
        
        //Updates players positions and stances.
        char1.setxCoord(Integer.parseInt(list1[0]));
        char1.setyCoord(Integer.parseInt(list1[1]));
        player1Save = list1[2];
        char1.setStance(Enum.valueOf(PlayerEntity.Stance.class, list1[3]));
        
        char2.setxCoord(Integer.parseInt(list2[0]));
        char2.setyCoord(Integer.parseInt(list2[1]));
        player2Save = list2[2];
        char2.setStance(Enum.valueOf(PlayerEntity.Stance.class, list2[3]));
        
        
        
        //Checks if there's any kind of collisions
        if (checkCornerLeft(char1))char1.setxCoord(1);
        if (checkCornerLeft(char2))char2.setxCoord(1);
        if (checkCornerRight(char1))char1.setxCoord(1919-char1.getWidth());
        if (checkCornerRight(char2))char2.setxCoord(1919-char2.getWidth());
        if (char2.getyCoord()<=30 &&char1.getyCoord()<= 30){
            if (char1.getFacing()==PlayerEntity.Facing.RIGHT && checkCollision()){
                char1.setxCoord(char1.getxCoord()-char1.getWalkspeed());
                char2.setxCoord(char2.getxCoord()+char2.getWalkspeed());
            }
            if (char1.getFacing()==PlayerEntity.Facing.LEFT && checkCollision()){
                char1.setxCoord(char1.getxCoord()+char1.getWalkspeed());
                char2.setxCoord(char2.getxCoord()-char2.getWalkspeed());  
            }
        }

        // Player 1 hits
        if (player1Move != ""){
            if ("A".equals(player1Move)){
                char1.attack('A');
            }
            checkHitboxCollision(char1, char2);
        }
        //Player 2 hits
        if (player2Move != ""){
            if ("A".equals(player2Move)){
                char2.attack('A');
            }
            checkHitboxCollision(char2, char1);
        }
        if (char1.getHealth() <= 0){
            dead1 = true;
            char1.setStance(PlayerEntity.Stance.DEFEATED);
            System.out.println("peli ohi");
        }
        if (char2.getHealth() <= 0){
            dead2 = true;
            char2.setStance(PlayerEntity.Stance.DEFEATED);
            System.out.println("peli ohi");
        }
    }

    /**
     * Listens keyinputs.
     */
    public void input() {
        long window = GLFW.glfwGetCurrentContext();
        if (char1.getStance()!=PlayerEntity.Stance.JUMPING&& dead1!=true &&char1.getState() == PlayerEntity.State.NEUTRAL){
            if (glfwGetKey(window, GLFW_KEY_A)==GLFW.GLFW_PRESS){
                inputB.player1Add("Left");
            }
            if (glfwGetKey(window, GLFW_KEY_D)==GLFW.GLFW_PRESS){
                inputB.player1Add("Right");
            }
            if (glfwGetKey(window, GLFW_KEY_W)==GLFW.GLFW_PRESS){
                inputB.player1Add("Up");
            }
            if (glfwGetKey(window, GLFW_KEY_S)==GLFW.GLFW_PRESS){
                inputB.player1Add("Down");
            }else
                char1.setStance(PlayerEntity.Stance.STANDING);
            if (glfwGetKey(window, GLFW_KEY_R)==GLFW.GLFW_PRESS){
                inputB.player1Add("A");
            }
        }
        if (char2.getStance()!=PlayerEntity.Stance.JUMPING&&dead2!=true&&char2.getState() == PlayerEntity.State.NEUTRAL){
            if (glfwGetKey(window, GLFW_KEY_LEFT)==GLFW.GLFW_PRESS){
                inputB.player2Add("Left");
            }
            if (glfwGetKey(window, GLFW_KEY_RIGHT)==GLFW.GLFW_PRESS){
                inputB.player2Add("Right");
            }
            if (glfwGetKey(window, GLFW_KEY_UP)==GLFW.GLFW_PRESS){
                inputB.player2Add("Up");
            }
            if (glfwGetKey(window, GLFW_KEY_DOWN)==GLFW.GLFW_PRESS){
                inputB.player2Add("Down");
            }else{
                char2.setStance(PlayerEntity.Stance.STANDING);
            }
            if (glfwGetKey(window, GLFW_KEY_PAGE_UP)==GLFW.GLFW_PRESS){
                inputB.player2Add("A"); 
            }
        }
    }

    /**
     * Renders textures to view.
     */
    public void render() {
        texture.bind();
        // current.state
    }

    /**
     * @This metod is called by view when we enter game state.
     */
    public void enter() {
        int width, height;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            long window = GLFW.glfwGetCurrentContext();
            IntBuffer widthBuffer = stack.mallocInt(1);
            IntBuffer heightBuffer = stack.mallocInt(1);
            width = widthBuffer.get();
            height = heightBuffer.get();
            GLFW.glfwGetFramebufferSize(window, widthBuffer, heightBuffer);
        }
        glClearColor(1.0f, 0.2f, 0.9f, 0f);
    }
}
