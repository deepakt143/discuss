package com.discuss.datatypes;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Deepak Thakur
 */
@Getter
public class Image {
    private String imageId;
    private String url;

    private Image(ImageBuilder imageBuilder) {
        this.imageId = imageBuilder.imageId;
        this.url = imageBuilder.url;
    }

    public static class ImageBuilder {
        private String imageId;
        private String url;

        public ImageBuilder() {
        }

        public ImageBuilder setImageId(final String imageId) {
            this.imageId = imageId;
            return this;
        }
        public ImageBuilder setUrl(final String url) {
            this.url = url;
            return this;
        }
        public Image build() {
            return new Image(this);
        }

    }
}
