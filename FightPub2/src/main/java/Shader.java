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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.lwjgl.opengl.GL20.*;
public class Shader {
    private int program;
    private int vs;
    private int fs;
    
    public Shader(String filename){
        program = glCreateProgram();
        
        vs = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vs, readFile(filename+".vs"));
        glCompileShader(vs);
        if (glGetShaderi(vs, GL_COMPILE_STATUS) != 1) {
            System.err.println(glGetShaderInfoLog(vs));
            System.exit(1);
        }
        
        fs = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fs, readFile(filename+".fs"));
        glCompileShader(fs);
        if (glGetShaderi(fs, GL_COMPILE_STATUS) != 1) {
            System.err.println(glGetShaderInfoLog(fs));
            System.exit(1);
        }
        
        glAttachShader(program, vs);
        glAttachShader(program, fs);
        
        glBindAttribLocation(program, 0, "vertices");
        glLinkProgram(program);
        if (glGetProgrami(program, GL_LINK_STATUS) != 1) {
            System.err.println(glGetProgramInfoLog(program));
            System.exit(1);
        }
        glValidateProgram(program);
                glLinkProgram(program);
        if (glGetProgrami(program, GL_VALIDATE_STATUS) != 1) {
            System.err.println(glGetProgramInfoLog(program));
            System.exit(1);
        }
    }
    
    public void bind(){
        glUseProgram(program);
    }
    
    private String readFile(String filename){
        StringBuilder string = new StringBuilder();
        BufferedReader br;
        File f = new File("");
        try {
            br = new BufferedReader(new FileReader(new File(f.getAbsolutePath() + "/src/main/java/shaders/" + filename)));
            String line;
            while((line = br.readLine()) != null){
                string.append(line);
                string.append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.toString();
    }
}
