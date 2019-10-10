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
    public static final int TARGET_UPS = 30;
    
    protected Window window;
    protected Timer timer;
    protected Renderer renderer;
    protected Controller controller;
    private boolean running;
    public static final int monitorHeigt = 1080;
    public static final int monitorWight = 1920;
    
    private final GLFWKeyCallback keyCallback;
    
    public View(){
        timer = new Timer();
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
        IntBuffer width = MemoryUtil.memAllocInt(1);
        IntBuffer height = MemoryUtil.memAllocInt(1);
        
        glfwSetKeyCallback(window, keyCallback);
        while (!glfwWindowShouldClose(window)) {
            controller.input();
            controller.update();
            // set background
            glClearColor(1.0f, 0.2f, 0.9f, 0f);
            glfwGetFramebufferSize(window, width, height);

            glClear(GL_COLOR_BUFFER_BIT);
            
            // draw objects
            drawObjects(width, height);
            
            glViewport(0, 0, width.get(), height.get());
            /* Swap buffers and poll Events */
            glfwSwapBuffers(window);
            glfwPollEvents();

            /* Flip buffers for next loop */
            width.flip();
            height.flip();
            
        }

        /* Free buffers */
        MemoryUtil.memFree(width);
        MemoryUtil.memFree(height);

        /* Release window and its callbacks */
        glfwDestroyWindow(window);

        /* Terminate GLFW and release the error callback */
        glfwTerminate();
        errorCallback.free();
    }
    
    public void drawObjects(IntBuffer width, IntBuffer height){
        Colour charColour = new Colour(0f, 1f, 0f);
        Colour hitboxColour = new Colour(1f, 0f, 0f);
        
        // char1
        drawSquare(controller.getCharacter1().getxCoord(),
            0,
            controller.getCharacter1().getStandingWidth(),
            controller.getCharacter1().getStandingHeight(),
            width,
            height,
            charColour
        );
            
        // char 2
        drawSquare(controller.getCharacter2().getxCoord(),
            0,
            controller.getCharacter2().getStandingWidth(), 
            controller.getCharacter2().getStandingHeight(),
            width,
            height,
            charColour
        );
        
        controller.getCharacter1().attack('A');
        controller.getCharacter2().attack('A');
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
        
    }
    
    public void drawSquare(int x, int y, int width, int height, IntBuffer widthbuffer, IntBuffer heightbuffer, Colour col){
        widthbuffer.rewind();
        heightbuffer.rewind();
        
        glViewport(x, y, width, height);

        glBegin(GL_TRIANGLES);

        glColor3f(col.getR(), col.getG(), col.getB());
        glVertex3f(-1.0f, -1.0f, 0.0f);
        glVertex3f(1.0f, 1.0f, 0.0f);
        glVertex3f(-1.f, 1.0f, -1.0f);

        glVertex3f(-1.0f, -1.0f, 0f);
        glVertex3f(1.0f, 1.0f, 0f);
        glVertex3f(1.0f, -1.0f, 1.0f);
        glEnd();
    }
}

