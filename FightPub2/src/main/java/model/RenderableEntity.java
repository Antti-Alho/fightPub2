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
 * Has all functionality that is needed to draw
 * @author antti
 */
public class RenderableEntity implements Renderable{
    protected final Colour colour;
    protected Texture texture;
    
    protected final int width;
    protected final int height;

    protected final int tx;
    protected final int ty;
    
    /**
     * Creates a renderable entity with a texture. 
     * @param color RGBA value that is used as background for the texture
     * @param texture texture object that is used when this entity is drawn
     * @param x x coordinate of the entity
     * @param y y coordinate of the entity
     * @param width width of the entity/texture
     * @param height height of the entity/texture
     * @param tx textures x coordinate in area
     * @param ty textures y coordinate in area
     */
    public RenderableEntity(Colour color, Texture texture, float x, float y, int width, int height, int tx, int ty) {
        this.colour = color;
        this.texture = texture;

        this.width = 100;
        this.height = 100;

        this.tx = 100;
        this.ty = 100;
    }
    
    public RenderableEntity(){
        this.colour = Colour.RED;

        this.width = 100;
        this.height = 100;

        this.tx = 100;
        this.ty = 100;
    }
    
    /**
     * renders this object to given location with given renderer
     * @param renderer
     * @param x
     * @param y
     * @param width
     * @param height
     * @param colour RGBA value to use
     */
    @Override
    public void render(Renderer renderer, float x, float y, float width, float height, Colour colour) {
        renderer.drawArea(x, y, x , y , colour);
    }
    
    @Override
    public void render(Renderer renderer, float x, float y, Colour colour) {
        renderer.drawTextureRegionWithColour(texture, x, y, (float) tx, (float) ty, (float) width, (float) height, colour);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public void setTexture(Texture t) {
        this.texture = t;
    }

}
