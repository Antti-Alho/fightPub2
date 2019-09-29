package view;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.system.MemoryUtil.NULL;
/**
 *
 * @author Heidi, Antti
 */
public class Window {
    private final long id;

    
    
    
    Window(int WIDTH, int HEIGHT, String title) {
        id = glfwCreateWindow(WIDTH, HEIGHT, title, NULL, NULL);
        if (id == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }
        
         // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE); // the window will be resizable
        
        // Get the resolution of the primary monitor
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        // Center our window
        glfwSetWindowPos(
                id,
                (vidmode.width() - WIDTH) / 2,
                (vidmode.height() - HEIGHT) / 2
        );
        
        // Make the OpenGL context current
        glfwMakeContextCurrent(id);
        GL.createCapabilities();
                
        // Enable v-sync
        glfwSwapInterval(1);
        glClearColor(1.0f, 0.0f, 1.0f, 0.0f);
        // Make the window visible
        glfwShowWindow(id);
        
    }

    boolean isClosing() {
        System.out.println("Window Closing here");
        return false;
    }

    void update() {
        glfwSwapBuffers(id);
        glfwPollEvents();
    }
    
        
    
}
