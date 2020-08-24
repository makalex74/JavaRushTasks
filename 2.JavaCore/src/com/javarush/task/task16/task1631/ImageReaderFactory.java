package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType){
        ImageReader imageReaderRes = null;
        if (imageType == null)
            throw new IllegalArgumentException("Неизвестный тип картинки");
        else
        if (imageType.equals(ImageTypes.BMP))
            imageReaderRes = new BmpReader();
        else
        if (imageType.equals(ImageTypes.JPG))
            imageReaderRes = new JpgReader();
        else
        if (imageType.equals(ImageTypes.PNG))
            imageReaderRes = new PngReader();

        return imageReaderRes;
    }
}