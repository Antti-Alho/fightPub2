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
        
        // Get the resolution of the primary monitor
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        
        glfwSetWindowPos(
                id,
                (vidmode.width() - WIDTH) / 2,
                (vidmode.height() - HEIGHT) / 2
        );
        
        glfwMakeContextCurrent(id);
        GL.createCapabilities();
        GLCapabilities caps = GL.getCapabilities();
        glfwSwapInterval(1);
        
        
        // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwDefaultWindowHints();
        if (caps.OpenGL32) {
            /* Hints for OpenGL 3.2 core profile */
            glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
            glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
            glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
            glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
        } else if (caps.OpenGL21) {
            /* Hints for legacy OpenGL 2.1 */
            glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 2);
            glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
        } else {
            throw new RuntimeException("Neither OpenGL 3.2 nor OpenGL 2.1 is "
                                       + "supported, you may want to update your graphics driver.");
        }
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        
        
        // Make the window visible
        //glfwShowWindow(id);
        
        
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
