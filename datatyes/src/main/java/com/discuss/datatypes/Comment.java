package com.discuss.datatypes;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Deepak Thakur
 */

@Getter
@Setter
@Builder
public class Comment implements Serializable {
    private int commentId;
    private String text;
    private String imageUrl;
    private int likes;
    private int views;
    private int personId;                        /*   posted by whom    */
    private String personName;                      /*   posted by whom    */
    private boolean liked;
}
