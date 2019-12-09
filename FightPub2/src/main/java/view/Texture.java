
package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13C.GL_CLAMP_TO_BORDER;
import static org.lwjgl.stb.STBImage.stbi_failure_reason;
import static org.lwjgl.stb.STBImage.stbi_load;
import static org.lwjgl.stb.STBImage.stbi_set_flip_vertically_on_load;
import org.lwjgl.system.MemoryStack;

/**
 * Stores texture data that has been passed to graphics card memory
 * @author Heidi, Antti
 */
public class Texture {
    
    private int id;
    private int width;
    private int height;

    /**
     * 
     * @param filename 
     */
    public Texture(String filename) {
        BufferedImage bi;
        try {
            bi = ImageIO.read(new File(filename));
            width = bi.getWidth();
            height = bi.getHeight();
            int[] pixels_raw = bi.getRGB(0, 0, width, height, null, 0, width);
            
            ByteBuffer pixels = BufferUtils.createByteBuffer(width * height * 4);
            
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int pixel = pixels_raw[i*width + j];
                    pixels.put((byte)((pixel >> 16) & 0xFF)); //red
                    pixels.put((byte)((pixel >> 8) & 0xFF)); // green
                    pixels.put((byte)(pixel & 0xFF)); //blue
                    pixels.put((byte)((pixel >> 24) & 0xFF)); //alpha
                }
            }
            
            pixels.flip();
            
            id = glGenTextures();
            
            glBindTexture(GL_TEXTURE_2D, id);
            
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_BYTE, pixels);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public Texture() {
        id = glGenTextures();
    }

    /**
     * Binds this texture to current GL_TEXTURE_2D context
     */
    public void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
    }
    
    /**
     * sets parameters for current GL_TEXTURE_2D context calling glTexParametri
     * @param name name of parameter
     * @param value value of parameter
     */
    public void setParameter(int name, int value) {
        glTexParameteri(GL_TEXTURE_2D, name, value);
    }
    
    /**
     * Uploads image data to graphic memory
     * @param width width of the image
     * @param height height of the image
     * @param data image data in ByteBuffer
     */
    public void uploadData(int width, int height, ByteBuffer data) {
        uploadData(GL_RGBA8, width, height, GL_RGBA, data);
    }

    /**
     * Uploads image data to graphic memory calling glTexImage2D
     * @param internalFormat 
     * @param width width of the image
     * @param height height of the image
     * @param format
     * @param data image data in ByteBuffer
     */
    public void uploadData(int internalFormat, int width, int height, int format, ByteBuffer data) {
        glTexImage2D(GL_TEXTURE_2D, 0, internalFormat, width, height, 0, format, GL_UNSIGNED_BYTE, data);
    }
    
    /**
     * Deletes this texture from graphic memory
     */
    public void delete() {
        glDeleteTextures(id);
    }
    
    public int getWidth() {
        return width;
    }

    /**
     * @param width must not be negative 
     */
    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    /**
     * @param height must not be negative 
     */
    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        }
    }

    /**
     * Creates a new texture.
     * @param width width of the image
     * @param height height of the image
     * @param data image data in ByteBuffer
     * @return new Texture object
     */
    public static Texture createTexture(int width, int height, ByteBuffer data) {
        Texture texture = new Texture();
        texture.setWidth(width);
        texture.setHeight(height);

        texture.bind();

        texture.setParameter(GL_TEXTURE_WRAP_S, GL_CLAMP_TO_BORDER);
        texture.setParameter(GL_TEXTURE_WRAP_T, GL_CLAMP_TO_BORDER);
        texture.setParameter(GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        texture.setParameter(GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        texture.uploadData(GL_RGBA8, width, height, GL_RGBA, data);

        return texture;
    }

    /**
     * Creates a new Texture Object from image
     * @param path path to image
     * @return new Texture object
     */
    public static Texture loadTexture(String path) {
        ByteBuffer image;
        int width, height;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            stbi_set_flip_vertically_on_load(true);
            image = stbi_load(path, w, h, comp, 4);
            if (image == null) {
                throw new RuntimeException("Failed to load a texture file!"
                                           + System.lineSeparator() + stbi_failure_reason());
            }

            width = w.get();
            height = h.get();
        }

        return createTexture(width, height, image);
    }

}
