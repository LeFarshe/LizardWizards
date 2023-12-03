package com.lizardwizards.lizardwizards.client.sprites;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import com.lizardwizards.lizardwizards.server.Session;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.net.URL;

public class ImageSprite extends EntitySprite {
    private transient Image spriteImage;
    private String imageFilename;
    private double imageScale;
    private double width;
    private double height;

    public ImageSprite(String imageFilename) {
        this.imageFilename = imageFilename;
        this.imageScale = 1;
        if (!LizardWizardsServer.isRunning) {
            loadImage();
            width = spriteImage.getWidth();
            height = spriteImage.getHeight();
        }
        else {
            var imageSize = ImageLookup.getImageSize(imageFilename);
            width = imageSize.x;
            height = imageSize.y;
        }
    }

   private void loadImage() {
        spriteImage = ImageLookup.loadImage(imageFilename);
   }

   public Image getImage() {
        if (spriteImage == null) {
            loadImage();
        }
        return spriteImage;
   }

    @Override
    public void scale(double sizeMultiplier) {
        imageScale = sizeMultiplier;
        width *= sizeMultiplier;
        height *= sizeMultiplier;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void setPosition(Vector2 position)
    {
        setTranslateX(position.x - width / 2);
        setTranslateY(position.y - height / 2);
    }

    @Override
    public void drawSprite(GraphicsContext gc) {
        if (spriteImage == null) {
            loadImage();
        }

        gc.drawImage(spriteImage, position.x, position.y, width, height);
    }

    @Override
    public ImageSprite clone() {
        ImageSprite sprite = (ImageSprite) super.clone();
        sprite.spriteImage = null;
        sprite.imageFilename = imageFilename;
        sprite.imageScale = imageScale;
        sprite.width = width;
        sprite.height = height;

        return sprite;
    }
}
