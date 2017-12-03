package com.discuss.datatypes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Builder;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author Deepak Thakur
 */
@Builder
@Getter
@Setter
public class Question implements Serializable {
    private int questionId;
    private String text;
    private String imageUrl;
    private int likes;
    private int views;
    private int personId;                        /*   posted by whom    */
    private String personName;                      /*   posted by whom    */
    private String difficulty;
    private boolean liked;
    private boolean bookmarked;
    private boolean answered;

    public void decrementLikes() {
        this.likes--;
    }
    public void incrementLikes() {
        this.likes++;
    }
}
