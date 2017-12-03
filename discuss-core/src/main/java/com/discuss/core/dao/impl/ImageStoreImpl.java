package com.discuss.core.dao.impl;

import com.discuss.core.dao.ImageStore;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * @author Deepak Thakur
 */
public class ImageStoreImpl implements ImageStore {

    private final String imageDir;

    public ImageStoreImpl(final String imageDir) {
        this.imageDir = imageDir;
    }

    @Override
    public String storeImage(String imageBase64String) {
        try {
            final String fileName = UUID.randomUUID().toString();
            File imageFile = new File(imageDir + fileName);
            FileUtils.touch(imageFile);
            FileUtils.writeStringToFile(imageFile, imageBase64String);
            return fileName;
        } catch (IOException e) {
            return null;
        }

    }

    @Override
    public String getImageWithId(String id) {
        File image = new File(id);
        if(image.exists()) {
            try {
                return FileUtils.readFileToString(image);
            } catch (IOException ignored) {
            }
        }
        return null;
    }
}
