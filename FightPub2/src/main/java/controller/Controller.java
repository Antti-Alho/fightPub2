package controller;

import java.awt.Rectangle;
import java.nio.IntBuffer;
import model.Character;
import model.MapModel;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11C.glClear;
import org.lwjgl.system.MemoryStack;


/**
 *
 * @author Heidi, Pate
 */
public class Controller {

    private Character char1;
    private Character char2;
    private int timelimit;
    private int rounds;
    private MapModel map;
    private view.Texture texture;

    public Controller(Character char1, Character char2, MapModel map, int timelimit, int rounds) {
        enter();
        this.char1 = char1;
        this.char2 = char2;
        this.map = map;
        this.timelimit = timelimit;
        this.rounds = rounds;
    }
    /**
     * Checks if the hurtboxes of characters are on top of each other.
     * returns true if characters are in collision
     * 
     * @return true if boxes collide
     */
    public boolean checkCollision(){        
        Rectangle character1 = new Rectangle(char1.getxCoord(), char1.getyCoord() ,char1.getHurtbox().getWidth(), char1.getHurtbox().getHeight());
        Rectangle character2 = new Rectangle(char2.getxCoord(), char2.getyCoord() ,char2.getHurtbox().getWidth(), char2.getHurtbox().getHeight());
        return character1.intersects(character2);
    }
    /**
     * 
     * @param hittingCharacter Character of player with active hitbox
     * @param characterGettingHit Character of player who might get hit
     * @return true if hitbox collides with hurtbox
     * 
     */
    public boolean checkHitboxCollision(Character hittingCharacter, Character characterGettingHit) {
        int hitboxWidth = hittingCharacter.getHitBox().getWidth();
        int hitboxHeight = hittingCharacter.getHitBox().getHeight();
        int hurtboxWidth = characterGettingHit.getHurtbox().getWidth();
        int hurtboxHeight = characterGettingHit.getHurtbox().getHeight();
        
        Rectangle hitbox = new Rectangle(hittingCharacter.getxCoord() + hittingCharacter.getHitBox().getXoffset(), hittingCharacter.getyCoord(), hitboxWidth, hitboxHeight);
        Rectangle hurtbox = new Rectangle(characterGettingHit.getxCoord(), characterGettingHit.getyCoord() ,hurtboxWidth, hurtboxHeight);
        System.out.println(hitbox.x + "hitbox vasen reuna");
        return hitbox.intersects(hurtbox);
    }
    
    public void checkFacing() {
        if (char1.getFacing() == Character.Facing.RIGHT && char1.getxCoord() > char2.getxCoord() ||
                char1.getFacing() == Character.Facing.LEFT && char1.getxCoord() < char2.getxCoord()) {
            char1.turn();
            char2.turn();
        }
    }


    public Character getCharacter1(){
        return this.char1;
    }
    public Character getCharacter2(){
        return this.char2;
    }

    public void update() {
        System.out.println("Players move here");
    }

    public void input() {
        System.out.println("Player inputs here");
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
            System.out.println("window: " + window);
            GLFW.glfwGetFramebufferSize(window, widthBuffer, heightBuffer);
        }
        
        
        glClearColor(1.0f, 0.2f, 0.9f, 0f);
        //glClearColor(1.0f, 0.2f, 0.9f, 0f);
        
    }
}
