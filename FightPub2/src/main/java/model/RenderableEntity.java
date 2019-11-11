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
package model;

import view.Colour;
import view.Renderer;
import view.Texture;

/**
 *
 * @author antti
 */
public class RenderableEntity {
    protected final Colour colour;
    protected Texture texture;
    
    protected final int width;
    protected final int height;

    protected final int tx;
    protected final int ty;
    
    public RenderableEntity(Colour color, Texture texture, float x, float y, int width, int height, int tx, int ty) {
        this.colour = color;
        this.texture = texture;

        this.width = width;
        this.height = height;

        this.tx = tx;
        this.ty = ty;
    }
    
    public RenderableEntity(Colour colour, int width, int height, int tx, int ty) {
        this.colour = colour;

        this.width = width;
        this.height = height;

        this.tx = tx;
        this.ty = ty;
        
    }
    
    public void render(Renderer renderer, float x, float y, Colour colour) {
        renderer.drawColour(x, y, x, y, y, y, y, y, colour);
        //renderer.drawTexture(texture, x, y, colour);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
}
}
