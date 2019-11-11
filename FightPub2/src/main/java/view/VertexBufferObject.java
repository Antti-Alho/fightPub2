package view;

import java.nio.FloatBuffer;
import static org.lwjgl.opengl.GL15.*;

/**
 * Stores VertexBufferObject id so that we can later bind or update it.
 * @author Heidi, Antti
 */
public class VertexBufferObject {
   
    private final int id;

    /**
     * Generates new bufferID with glGenBuffers
     */
    public VertexBufferObject() {
        id = glGenBuffers();
    }

    /**
     * Binds this buffer to target context using glBindBuffer
     * glBindBuffer binds a buffer object to the specified buffer binding point.
     * GL_ARRAY_BUFFER = Vertex attributes
     * GL_TEXTURE_BUFFER = Texture data buffer
     * @param target context
     */
    public void bind(int target) {
        glBindBuffer(target, id);
    }

    /**
     * calls glBufferData
     * glBufferData creates and initializes a buffer object's data store
     * @param target Specifies the target to which the buffer object is bound
     * @param data Specifies a pointer to data that will be copied into the data store.
     * @param usage Specifies the expected usage pattern of the data store. 
     */
    public void uploadData(int target, long data, int usage) {
        glBufferData(target, data, usage);
    }
    
    /**
     * Delete this buffer from memory.
     */
    public void delete() {
        glDeleteBuffers(id);
    }
    
    public int getID() {
        return id;
    }

    void uploadSubData(int target, int offset, FloatBuffer data) {
        glBufferSubData(target, offset, data);
    }
    
}
