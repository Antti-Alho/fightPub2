package view;

import controller.Controller;
import model.MapModel;
import java.nio.IntBuffer;
import model.PlayerEntity;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

import org.lwjgl.glfw.GLFWVidMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.system.MemoryUtil;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 *
 * @author Heidi, Antti
 */
public class View {
 
    public static final int TARGET_FPS = 60;
    protected Window window;
    protected Timer timer;
    protected Renderer renderer;
    protected Controller controller;
    public static final int monitorHeigt = 1080;
    public static final int monitorWight = 1920;
    
    private final GLFWKeyCallback keyCallback;
    
    
    /**
     * Constructor for new view class
     */
    public View(){
        timer = timer.getInstance();
        renderer = new Renderer();
        controller = new Controller("Pekka", "Pekka", new MapModel("Jee"), 100, 1);
        
        keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                    glfwSetWindowShouldClose(window, true);
                }
            }
        };
    }
    
    /**
     * This error callback will simply print the error to
     * <code>System.err</code>.
     */
    private static GLFWErrorCallback errorCallback = GLFWErrorCallback.createPrint(System.err);

    /**
     * Starts the view and runs it as a loop.
     */
    public void run() {
        long window;

        glfwSetErrorCallback(errorCallback);

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        window = glfwCreateWindow(monitorWight, monitorHeigt, "Simple example", NULL, NULL);
        if (window == NULL) {
            glfwTerminate();
            throw new RuntimeException("Failed to create the GLFW window");
        }

        /* Center the window on screen */
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window,
                         (vidMode.width() - monitorWight) / 2,
                         (vidMode.height() - monitorHeigt) / 2
        );
        
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        
        // v-sync
        glfwSwapInterval(1);
        
         // Declare buffers for using inside the loop
        IntBuffer width = MemoryUtil.memAllocInt(1);
        IntBuffer height = MemoryUtil.memAllocInt(1);
        
        glfwSetKeyCallback(window, keyCallback);
        
        // Updates view in a loop until esc-button is pressed.
        while (!glfwWindowShouldClose(window)) {
            controller.input();
            controller.update();
            
            // set background
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            
            glfwGetFramebufferSize(window, width, height);
            glClear(GL_COLOR_BUFFER_BIT);
            
            // draw objects
            drawObjects(width, height);
            // gives the view size
            glViewport(0, 0, width.get(), height.get());
            
            // Swap buffers and poll Events
            glfwSwapBuffers(window);
            glfwPollEvents();

            // Flip buffers for next loop
            width.flip();
            height.flip();
            
        }

        // Free buffers
        MemoryUtil.memFree(width);
        MemoryUtil.memFree(height);

        // Release window and its callbacks
        glfwDestroyWindow(window);

        // Terminate GLFW and release the error callback
        glfwTerminate();
        errorCallback.free();
    }
    /**
     * Draws all objects to the current window.
     * @param width integer buffer for width
     * @param height integer buffer for height
     */
    public void drawObjects(IntBuffer width, IntBuffer height){
        Colour char1Colour = new Colour(0f, 1f, 0f);
        Colour char2Colour = new Colour(0f, 0f, 1f);
        Colour hitboxColour = new Colour(1f, 0f, 0f);
        Colour healthColour = new Colour(0f, 1f, 1f);
        // char1
        drawSquare(controller.getCharacter1().getxCoord(),
            controller.getCharacter1().getyCoord(),
            controller.getCharacter1().getWidth(),
            controller.getCharacter1().getHeight(),
            width,
            height,
            char1Colour
        );
            
        // char 2
        drawSquare(controller.getCharacter2().getxCoord(),
            controller.getCharacter2().getyCoord(),
            controller.getCharacter2().getWidth(),
            controller.getCharacter2().getHeight(),
            width,
            height,
            char2Colour
        );

        // hitbox 1
        drawSquare(controller.getCharacter1().getHitBox().getXoffset() + controller.getCharacter1().getxCoord(),
            controller.getCharacter1().getHitBox().getYoffset() + controller.getCharacter1().getyCoord(),
            controller.getCharacter1().getHitBox().getWidth(), 
            controller.getCharacter1().getHitBox().getHeight(),
            width,
            height,
            hitboxColour
        );
        
        //hitbox 2
        drawSquare(controller.getCharacter2().getHitBox().getXoffset() + controller.getCharacter2().getxCoord(),
            controller.getCharacter2().getHitBox().getYoffset() + controller.getCharacter2().getyCoord(),
            controller.getCharacter2().getHitBox().getWidth(), 
            controller.getCharacter2().getHitBox().getHeight(),
            width,
            height,
            hitboxColour
        );
        
        //healthbox 1
        drawSquare(0+((100-controller.getCharacter1().getHealth())*8), 1000,
            800-((100-controller.getCharacter1().getHealth())*8), 
            1080,
            width,
            height,
            healthColour
        );

        //healthbox 2
        drawSquare(1120, 1000,
            controller.getCharacter2().getHealth()*8, 
            1080,
            width,
            height,
            healthColour
        );
        
        //Characterbox1
        drawSquare(800, 920,
            160, 
            1080,
            width,
            height,
            char1Colour
        );
        
        //Characterbox2
        drawSquare(960, 920,
            160, 
            1080,
            width,
            height,
            char2Colour
        );
    }
    
    /**
     * Fill the objets by drawing square by two triangles and fills them with colour.
     * @param x starting plase in x-scale for square
     * @param y starting plase in y-scale for square
     * @param width width of the square
     * @param height height of the square
     * @param widthbuffer integer buffer for width
     * @param heightbuffer integer buffer for height
     * @param col square colour
     */
    public void drawSquare(int x, int y, int width, int height, IntBuffer widthbuffer, IntBuffer heightbuffer, Colour col){
        widthbuffer.rewind();
        heightbuffer.rewind();
        
        // gives the object size
        glViewport(x, y, width, height);
        
        // Start drawing triangles
        glBegin(GL_TRIANGLES);
        // Colour for the triangles
        glColor3f(col.getR(), col.getG(), col.getB());
        // First triangle
        glVertex3f(-1.0f, -1.0f, 0.0f);
        glVertex3f(1.0f, 1.0f, 0.0f);
        glVertex3f(-1.f, 1.0f, -1.0f);
        // Second triangle
        glVertex3f(-1.0f, -1.0f, 0f);
        glVertex3f(1.0f, 1.0f, 0f);
        glVertex3f(1.0f, -1.0f, 1.0f);
        // End drawing
        glEnd();
    }
}

