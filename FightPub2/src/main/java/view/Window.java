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
    private final GLFWKeyCallback keyCallback;

    Window(int width, int height, String title) {
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        id = glfwCreateWindow(width, height, title, NULL, NULL);
        if (id == NULL) {
            glfwTerminate();
            throw new RuntimeException("Failed to create the GLFW window!");
        }
        
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(id,
                         (vidmode.width() - width) / 2,
                         (vidmode.height() - height) / 2
        );
        glfwMakeContextCurrent(id);
        GL.createCapabilities();
        //v-sync
        glfwSwapInterval(1);
        
        
        /* Pressing ESC closes this window next time its rendered */
        keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                    glfwSetWindowShouldClose(window, true);
                }
            }
        };
        glfwSetKeyCallback(id, keyCallback);
    }

    public boolean isClosing() {
        System.out.println("Window Closing here");
        return glfwWindowShouldClose(id);
    }

    public void update() {
        glfwSwapBuffers(id);
        glfwPollEvents();
    }
    
    public void destroy() {
        glfwDestroyWindow(id);
        keyCallback.free();
    }  
    
}
