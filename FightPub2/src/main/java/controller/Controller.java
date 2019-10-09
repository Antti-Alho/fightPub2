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
import model.HitBox;
import model.HurtBox;

/**
 * This class initializes the game. Contains methods to check game state.
 * @author Heidi, Pate, Joonas
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

        this.char2 = db.getPlayerEntity(char2);
        this.char2.setFacing(PlayerEntity.Facing.LEFT);
        this.char1.setxCoord(400);
        this.char2.setxCoord(1200);
        this.char1.setHurtBox(new HurtBox(200, 400));
        this.char2.setHurtBox(new HurtBox(200, 400));
        this.char1.setHitBox(new HitBox(0, 0, 0, 0, 0, HitBox.HitLocation.HIGH));
        this.char2.setHitBox(new HitBox(0, 0, 0, 0, 0, HitBox.HitLocation.HIGH));
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
     * Checks if the hitting characters hitbox collides with 
     * the other characters hurtbox
     * 
     * @param hittingCharacter Character of player with active hitbox
     * @param characterGettingHit Character of player who might get hit
     * @return true if hitbox collides with hurtbox
     */
    public boolean checkHitboxCollision(PlayerEntity hittingCharacter, PlayerEntity characterGettingHit) {
        
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
        if (char1.getFacing() == PlayerEntity.Facing.RIGHT && char1.getxCoord() > char2.getxCoord()
                || char1.getFacing() == PlayerEntity.Facing.LEFT && char1.getxCoord() < char2.getxCoord()) {
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

    public void update() {
        System.out.println("Players move here");
    }

    public void input() {
        System.out.println("input hetre");
    }
    

    public void render() {
        texture.bind();
        System.out.println("Render here");
        // current.state
    }
    
    public void enter(){
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
