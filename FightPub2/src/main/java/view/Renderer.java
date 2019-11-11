
package view;

import java.nio.FloatBuffer;
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
import org.lwjgl.system.MemoryUtil;
/**
 * WIP: Renderer stores Vertex data that has been passed to Graphics card memory.
 * So that we can later use or change that data from the graphic card memory.
 * @author Heidi, Antti
 */
public class Renderer {
    private VertexArrayObject vao;
    private VertexBufferObject vbo;
    private FloatBuffer vertices;
    private int numVertices;
    private boolean drawing;

    void init() {
        setup();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void begin() {
        if (drawing) {
            throw new IllegalStateException("Renderer is already drawing!");
        }
        drawing = true;
        numVertices = 0;
    }

    public void end() {
        if (!drawing) {
            throw new IllegalStateException("Renderer isn't drawing!");
        }
        drawing = false;
        flush();
    }

    private void flush() {
        if (numVertices > 0) {
            vertices.flip();

            if (vao != null) {
                vao.bind();
            } else {
                vbo.bind(GL_ARRAY_BUFFER);
            }
            vbo.bind(GL_ARRAY_BUFFER);
            vbo.uploadSubData(GL_ARRAY_BUFFER, 0, vertices);
            glDrawArrays(GL_TRIANGLES, 0, numVertices);
            vertices.clear();
            numVertices = 0;
        }
    }

    public void drawTexture(Texture texture, float x, float y, Colour c) {
        float x1 = x;
        float y1 = y;
        float x2 = x1 + texture.getWidth();
        float y2 = y1 + texture.getHeight();

        float s1 = 0f;
        float t1 = 0f;
        float s2 = 1f;
        float t2 = 1f;

        drawColour(x1, y1, x2, y2, s1, t1, s2, t2, c);
    }

 
    public void drawWhiteTextureRegion(Texture texture, float x, float y, float regX, float regY, float regWidth, float regHeight) {
        drawTextureRegionWithColour(texture, x, y, regX, regY, regWidth, regHeight, Colour.WHITE);
    }


    public void drawTextureRegionWithColour(Texture texture, float x, float y, float regX, float regY, float regWidth, float regHeight, Colour c) {
        float x1 = x;
        float y1 = y;
        float x2 = x + regWidth;
        float y2 = y + regHeight;

        float s1 = regX / texture.getWidth();
        float t1 = regY / texture.getHeight();
        float s2 = (regX + regWidth) / texture.getWidth();
        float t2 = (regY + regHeight) / texture.getHeight();

        drawColour(x1, y1, x2, y2, s1, t1, s2, t2, c);
    }

    public void drawWhite(float x1, float y1, float x2, float y2, float s1, float t1, float s2, float t2) {
        drawColour(x1, y1, x2, y2, s1, t1, s2, t2, Colour.WHITE);
    }

    public void drawColour(float x1, float y1, float x2, float y2, float s1, float t1, float s2, float t2, Colour c) {
        if (vertices.remaining() < 7 * 6) {
            flush();
        }

        float r = c.getR();
        float g = c.getG();
        float b = c.getB();
        float a = c.getA();

        vertices.put(x1).put(y1).put(r).put(g).put(b).put(a).put(s1).put(t1);
        vertices.put(x1).put(y2).put(r).put(g).put(b).put(a).put(s1).put(t2);
        vertices.put(x2).put(y2).put(r).put(g).put(b).put(a).put(s2).put(t2);

        vertices.put(x1).put(y1).put(r).put(g).put(b).put(a).put(s1).put(t1);
        vertices.put(x2).put(y2).put(r).put(g).put(b).put(a).put(s2).put(t2);
        vertices.put(x2).put(y1).put(r).put(g).put(b).put(a).put(s2).put(t1);

        numVertices += 6;
    }
    
    public void dispose() {
        MemoryUtil.memFree(vertices);
        vao.delete();
        vbo.delete();
    }
    
    private void setup() {
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

}
