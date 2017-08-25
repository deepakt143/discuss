package com.discuss.datatypes;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Comment {
    private String commentId;
    private String text;
    private Set<String> imageIds;
    private Long upvotes;
    private Long downvotes;
    private Long views;
    private String userId;                        /*   posted by whom    */
    private String userName;                      /*   posted by whom    */
}
