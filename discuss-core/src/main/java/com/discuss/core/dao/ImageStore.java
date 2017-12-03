package com.discuss.core.dao;

/**
 *
 * @author Deepak Thakur
 */
public interface ImageStore {
    String storeImage(String imageBase64String);
    String getImageWithId(String id);
}
