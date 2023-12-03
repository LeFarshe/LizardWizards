package com.lizardwizards.lizardwizards.client.sprites;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.core.Vector2;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

public class ImageLookup {
    static HashMap<String, Image> imageTable = HashMap.newHashMap(7);
    static byte[] pngMagicNumber = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};

    public static Image loadImage(String filename) {
        var image = imageTable.get(filename);
        if (image == null) {
            URL imageURL = ClientUtils.loadResource(filename);
            image = new Image(imageURL.toExternalForm());
            imageTable.put(filename, image);
        }
        return image;
    }

    private static int convertPNGDataToInt(byte[] bytes) {
        return  ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8 ) |
                ((bytes[3] & 0xFF));
    }

    public static Vector2 getImageSize(String filename) {
        URL imageURL = ClientUtils.loadResource(filename);
        try {
            var image = imageURL.openStream();
            var magicNumber = image.readNBytes(8);
            for (int i = 0; i < 8; i++){
                if (magicNumber[i] != pngMagicNumber[i]) {
                    throw new RuntimeException("Image not .png");
                }
            }

            long skipped = image.skip(8);
            if (skipped < 8) {
                throw new RuntimeException("PNG missing IHDR chunk");
            }
            int width = convertPNGDataToInt(image.readNBytes(4));
            int height = convertPNGDataToInt(image.readNBytes(4));
            return new Vector2(width, height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
