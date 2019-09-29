package view;
import static org.lwjgl.opengl.GL30.*;

/**
 *
 * @author Heidi, Antti
 */
public class VertexArrayObject {
    
    private final int id;

    public VertexArrayObject() {
        id = glGenVertexArrays();
    }

    public void bind() {
        glBindVertexArray(id);
    }

    public void delete() {
        glDeleteVertexArrays(id);
    }

    public int getID() {
        return id;
    }

}