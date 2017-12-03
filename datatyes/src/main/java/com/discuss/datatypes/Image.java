package com.discuss.datatypes;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Builder;

/**
 * @author Deepak Thakur
 */
@Getter
@Setter
@Builder
public class Image {
    private String imageId;
    private String url;
}
