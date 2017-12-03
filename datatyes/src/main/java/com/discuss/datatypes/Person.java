package com.discuss.datatypes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Builder;

import java.util.List;

/**
 * @author Deepak Thakur
 */
@Builder
@Getter
@Setter
public class Person {
    private String personId;
    private List<Question> questionsPosted;
    private List<Comment> commentsAdded;
    private int rating;
    private List<Question> bookMarked;
    private List<Category> categoriesOfInterest;
}
