package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.io.Reader;
import java.util.Optional;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type) {
        if (type == null) throw new IllegalArgumentException("Unexpected value: " + null);
        ImageReader reader;
        switch (type) {
            case BMP: {
                reader = new BmpReader();
                break;
            }
            case JPG: {
                reader = new JpgReader();
                break;
            }
            case PNG: {
                reader = new PngReader();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return reader;
    }


}
