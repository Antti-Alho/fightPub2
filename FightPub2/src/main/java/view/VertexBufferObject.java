package view;

import java.nio.FloatBuffer;
import static org.lwjgl.opengl.GL15.*;

/**
 *
 * @author Heidi, Antti
 */
public class VertexBufferObject {
   
    private final int id;

    public VertexBufferObject() {
        id = glGenBuffers();
    }

    public void bind(int target) {
        glBindBuffer(target, id);
    }

    public void uploadData(int target, long data, int usage) {
        glBufferData(target, data, usage);
    }

    
    
}
