
package view;

import static org.lwjgl.glfw.GLFW.glfwGetTime;
/**
 * Keeps track of FPS and game time since last frame update.
 * @author Heidi
 */
public class Timer {

    private double lastLoopTime;
    private float timeCount;
    private int fpsCount, fps = 0;
    
    /**
     * sets current time to lastLoopTime
     */
    void init() {
        lastLoopTime = glfwGetTime();
    }

    /**
     * Updates FPS if more than 1 second has passed since last FPS update
     * Removes one second from timeCount
     */
    void update() {
        double time = glfwGetTime();
        float delta = (float)(time - lastLoopTime);
        lastLoopTime = time;
        timeCount += delta;
        fpsCount++;
        if (timeCount > 1f){
            fps = fpsCount;
            fpsCount = 0;
            timeCount -= 1f;
        }
    }

    public double getLastLoopTime() {
        return lastLoopTime;
    }
    public int getFPS() {
        return fps;
    }
    
    public double getTime() {
        return glfwGetTime();
    }

    void updateFPS() {
        fpsCount++;
    }

    float getDelta() {
        double time = getTime();
        float delta = (float) (time - lastLoopTime);
        lastLoopTime = time;
        timeCount += delta;
        return delta;
    }
    
}
