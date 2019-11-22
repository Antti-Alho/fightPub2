package view;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

/**
 * Keeps track of FPS and game time since last frame update.
 *
 * @author Heidi
 */
public class Timer {

    private double lastLoopTime;
    private float timeCount;
    private int fpsCount, fps = 0, fpsCounter;

    /**
     * sets current time to lastLoopTime
     */
    void init() {
        lastLoopTime = glfwGetTime();
    }

    private Timer() {

    }

    public static Timer getInstance() {
        return TimerContainer.timer;
    }

    private static class TimerContainer {

        private static final Timer timer = new Timer();

    }

    /**
     * Updates FPS if more than 1 second has passed since last FPS update
     * Removes one second from timeCount
     */
    void update() {
        double time = glfwGetTime();
        float delta = (float) (time - lastLoopTime);
        lastLoopTime = time;
        timeCount += delta;
        fpsCount++;
        fpsCounter++;
        if (timeCount > 1f) {
            fps = fpsCount;
            fpsCount = 0;
            timeCount -= 1f;
        }
    }

    float getDelta() {
        double time = glfwGetTime();
        float delta = (float) (time - lastLoopTime);
        lastLoopTime = time;
        timeCount += delta;
        return delta;
    }

    public double getLastLoopTime() {
        return lastLoopTime;
    }

    public int getFPS() {
        return fps;
    }

    public int getFpsCounter() {
        return this.fpsCounter;
    }

}
