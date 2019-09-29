
package view;

import static org.lwjgl.glfw.GLFW.glfwGetTime;
/**
 *
 * @author Heidi
 */
public class Timer {

    private double lastLoopTime;
    private float timeCount;
    private int upsCount, fpsCount, fps, ups;
    
    
    void init() {
        lastLoopTime = glfwGetTime();
    }

    float getDelta() {
        double time = glfwGetTime();
        float delta = (float)(time - lastLoopTime);
        lastLoopTime = time;
        timeCount += delta;
        return delta;
    }

    void updateUPS() {
        upsCount++;
    }

    void updateFPS() {
        fpsCount++;
    }

    void update() {
        if (timeCount > 1f){
            fps = fpsCount;
            fpsCount = 0;
            ups = upsCount;
            upsCount = 0;
            timeCount -=1f;
        }
    }
    
}
