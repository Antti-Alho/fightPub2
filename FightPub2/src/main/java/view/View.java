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
    private static GLFWErrorCallback errorCallback
                                     = GLFWErrorCallback.createPrint(System.err);

   
    public  void run() {
        long window;

        /* Set the error callback */
        glfwSetErrorCallback(errorCallback);

        /* Initialize GLFW */
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        /* Create window */
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
            
            glClearColor(1.0f, 0.2f, 0.9f, 0f);
            /* Get width and height to calcualte the ratio */
            glfwGetFramebufferSize(window, width, height);

            /* Rewind buffers for next get */
            width.rewind();
            height.rewind();

            /* Set hurtbox and clear screen */
            // (Xcoord, ycoord, leveys, korkeus)
            glViewport(controller.getCharacter1().getxCoord(), 0, 
                    controller.getCharacter1().getStandingWidth(), 
                    controller.getCharacter1().getStandingHeight());
            glClear(GL_COLOR_BUFFER_BIT);

            /* Set ortographic projection */
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glMatrixMode(GL_MODELVIEW);

            /* Render triangle */
            glBegin(GL_TRIANGLES);
            glColor3f(0f, 1f, 0f);
            glVertex3f(-1.0f, -1.0f, 0.0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(1.0f, 1.0f, 0.0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(-1.f, 1.0f, -1.0f);

            glColor3f(0f, 1f, 0f);
            glVertex3f(-1.0f, -1.0f, 0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(1.0f, 1.0f, 0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(1.0f, -1.0f, 1.0f);
            
            glEnd();
   
            /* Rewind buffers for next get */
            width.rewind();
            height.rewind();
            
            glViewport(controller.getCharacter2().getxCoord(), 0,
                    controller.getCharacter2().getStandingWidth(), 
                    controller.getCharacter2().getStandingHeight());

            /* Set ortographic projection */
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glMatrixMode(GL_MODELVIEW);

            /* Render triangle */
            glBegin(GL_TRIANGLES);
            glColor3f(0f, 1f, 0f);
            glVertex3f(-1.0f, -1.0f, 0.0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(1.0f, 1.0f, 0.0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(-1.f, 1.0f, -1.0f);

            glColor3f(0f, 1f, 0f);
            glVertex3f(-1.0f, -1.0f, 0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(1.0f, 1.0f, 0f);
            glColor3f(0f, 1f, 0f);
            glVertex3f(1.0f, -1.0f, 1.0f);
            glEnd();

            //Estää glfwGetFramebufferSize:ia kaatumasta
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
}

