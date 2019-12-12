/*
 * Copyright (C) 2019 antti
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author antti
 */

import java.io.File;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL11.*;
import view.Texture;

public class TestMain {
    
    public static void main(String[] args) {

        if(glfwInit() != true){
            System.out.println("GLFW init failed");
            System.exit(1);
        }
        
        long win = glfwCreateWindow(400, 466, "Window", 0, 0);
        
        glfwShowWindow(win);
        glfwMakeContextCurrent(win);
        
        GL.createCapabilities();
        glEnable(GL_TEXTURE_2D);
        
        float[] vertices = new float[] {
            -1f, 1f, 0, //top left 0
            1f, 1f ,0, // top right 1
            1f, -1f, 0, // bottom right 2
            -1f, -1f, 0, // bottom left 3
        };
        
        float[] texture = new float[] {
            0,0, //0
            1,0, //1
            1,1, //2
            0,1, //3
        };
        
        int[] indicies = new int[] {
            0,1,2,
            2,3,0
        };
        
        File f = new File("");
        //Shader shader = new Shader("shader");
        Texture tex = new Texture(f.getAbsolutePath() + "/src/main/java/assets/ruy.png");
        Model model = new Model(vertices, texture, indicies, tex, null);

        while(glfwWindowShouldClose(win) == false) {
            if (glfwGetKey(win, GLFW_KEY_ESCAPE) == GL_TRUE){
                glfwSetWindowShouldClose(win, true);
            }
            
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT);
            
            model.render(0,0);
            
            glfwSwapBuffers(win);
        }
    }
}
