package com.discuss.datatypes;

import lombok.Data;

import java.util.List;

@Data
public class UserProfile {
    private String userId;
    private List<Question> questionsPosted;
    private List<Comment> commentsAdded;
    private int rating;
    private List<Question> bookMarked;
    private List<Category> categoriesOfInterest;
}
