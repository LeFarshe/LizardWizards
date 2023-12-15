package com.lizardwizards.lizardwizards.client.loading;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ResourceLoaderProxy implements ResourceLoader {
    private ConcreteResourceLoader realLoader;
    private GraphicsContext gc;

    public ResourceLoaderProxy(ConcreteResourceLoader realLoader, GraphicsContext gc) {
        this.realLoader = realLoader;
        this.gc = gc;
    }

    @Override
    public void loadResources() {
        showLoadingScreen();
        realLoader.loadResources();
    }

    private void showLoadingScreen() {
        gc.setFont(new Font("Sans", 100));
        gc.setFill(Color.GOLDENROD);
        gc.fillText("Loading...", 500, 500);
        var image = new ImageSprite("images/loading.png");
        image.setPosition(new Vector2(1100, 450));
        image.drawSprite(gc);
    }


}