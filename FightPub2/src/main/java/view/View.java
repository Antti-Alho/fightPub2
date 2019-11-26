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
 
    protected Window window;
    protected Timer timer;
    protected Renderer renderer;
    protected StateMachine stateMachine;
    protected Controller controller;

    public static final int TARGET_FPS = 60;
    public static final int monitorHeigt = 1080;
    public static final int monitorWidth = 1920;
    private GLFWErrorCallback errorCallback;

    private boolean running;

    /**
     * Constructor for new view class
     */
    public View(){
        timer = new Timer();
        renderer = new Renderer();
        stateMachine = new StateMachine();
    }

    public void start() {
        init();
        run();
        dispose();
    }

    public void run() {
        float deltaTime;
        float accumulator = 0f;
        float interval = 1f / TARGET_FPS;

        while (running) {
            if (window.isClosing()) {
                running = false;
            }
            deltaTime = timer.getDelta();
            accumulator += deltaTime;

            stateMachine.input();
            while (accumulator >= interval) {
                stateMachine.update();
                accumulator -= interval;
            }
            stateMachine.render();
            timer.update();
            window.update();

            sync(TARGET_FPS);
        }
    } 

    private void init() {
        errorCallback = GLFWErrorCallback.createPrint();
        glfwSetErrorCallback(errorCallback);
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW!");
        }

        window = new Window(monitorWidth, monitorHeigt, "Fight Pub 2");

        timer.init();
        renderer.init();
        initStates();
        running = true;
    }

    private void dispose() {
        renderer.dispose();
        stateMachine.change(null);
        window.destroy();
        glfwTerminate();
        errorCallback.free();
    }

    private void initStates() {
        stateMachine.add("game", new Controller(renderer, "Jukka", "Pekka", new MapModel("Kannunkulma"), GL_MULT, GL_ADD));
        stateMachine.change("game");
    }
    
    public void sync(int fps) {
        double lastLoopTime = timer.getLastLoopTime();
        double now = timer.getTime();
        float targetTime = 1f / fps;

        while (now - lastLoopTime < targetTime) {
            Thread.yield();
            now = timer.getTime();
        }
    }
    
}
