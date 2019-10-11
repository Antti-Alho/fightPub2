package view;
import static org.lwjgl.opengl.GL30.*;

/**
 * Stores VertexArrayObjects location in memory so that we can bind or delete it when needed.
 * @author Heidi Antti
 */
public class VertexArrayObject {
    
    private final int id;

    /**
     * calls glGenVertexArrays() and stores the id.
     */
    public VertexArrayObject() {
        id = glGenVertexArrays();
    }

    /**
     * Binds this object to current openGL context
     */
    public void bind() {
        glBindVertexArray(id);
    }

    /**
     * Deletes this object from memory
     */
    public void delete() {
        glDeleteVertexArrays(id);
    }

    public int getID() {
        return id;
    }

}