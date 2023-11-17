package com.lizardwizards.lizardwizards.client.sprites;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import com.lizardwizards.lizardwizards.server.Session;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.net.URL;

public class ImageSprite extends EntitySprite {
    private transient Image spriteImage;
    private final String imageFilename;
    private double imageScale;
    private final double width;
    private final double height;

    public ImageSprite(String imageFilename) {
        this.imageFilename = imageFilename;
        this.imageScale = 1;
        if (!LizardWizardsServer.isRunning) {
            loadImage();
            width = spriteImage.getWidth();
            height = spriteImage.getHeight();
        }
        else {
            width = 0;
            height = 0;
        }
    }

    public ImageSprite(URL imageURL) {
        this(imageURL.toExternalForm());
    }

   private void loadImage() {
        spriteImage = new Image(imageFilename);
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

        gc.drawImage(spriteImage, position.x, position.y, width*imageScale, height*imageScale);
    }
}
