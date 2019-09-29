package view;

import controller.Controller;
import model.MapModel;
import controller.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.opengl.GL11.glClearColor;

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
    
    public View(){
        timer = new Timer();
        renderer = new Renderer();
        controller = new Controller(new model.Character(true, "Jaakko"), new model.Character(false, "Pekka"), new MapModel("Jee"), 100, 1);
    }
    
    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        try {
            init();
            loop();
        } finally {
            glfwTerminate();
            glfwSetErrorCallback(null).free();
        }
    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        int WIDTH = 1920;
        int HEIGHT = 1080;
        
        // Create the window
        window = new Window(WIDTH, HEIGHT, "Fight Pub 2");
        
        timer.init();
        renderer.init();

        running = true;
    }

    private void loop() {
        float delta;
        float accumulator = 0f;
        float interval = 1f / TARGET_UPS;
        float alpha;
        

        while (running) {
            if (window.isClosing()){
                running = false;
            }
            delta = timer.getDelta();
            accumulator += delta;
            
            input();
            
            while (accumulator >= interval){
                update();
                timer.updateUPS();
                accumulator -= interval;
            }
            alpha = accumulator / interval;
            render();
            timer.updateFPS();
            
            timer.update();
            
            window.update();
        }
    }

    public static void main(String[] args) {
        new View().run();
    }

    private void input() {
        controller.input();
    }

    private void update() {
        controller.update();
    }

    private void render() {
        controller.render();
    }


}
