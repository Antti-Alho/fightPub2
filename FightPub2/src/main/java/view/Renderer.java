
package view;

import org.lwjgl.opengl.GL11;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_DYNAMIC_DRAW;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

/**
 *
 * @author Heidi, Antti
 */
public class Renderer {
    private VertexArrayObject vao;
    private VertexBufferObject vbo;
    private FloatBuffer vertices;
    private int numVertices;
    private boolean drawing;

    void init() {
        vao = new VertexArrayObject();
        vao.bind();
        
        
        vbo = new VertexBufferObject();
        vbo.bind(GL_ARRAY_BUFFER);
        vertices = MemoryUtil.memAllocFloat(4096);
        
        long size = vertices.capacity() * Float.BYTES;
        vbo.uploadData(GL_ARRAY_BUFFER, size, GL_DYNAMIC_DRAW);
        numVertices = 0;
        drawing = false;
        
    }
    
    public void drawSquare(int x1, int x2, int y1, int y2){
        
                        
    }

    
}
