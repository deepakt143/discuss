package com.discuss.datatypes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class User {
    private String userId;
    private List<Question> questionsPosted;
    private List<Comment> commentsAdded;
    private int rating;
    private List<Question> bookMarked;
    private List<Category> categoriesOfInterest;

    private User(UserBuilder userBuilder) {
        this.userId = userBuilder.userId;
        this.questionsPosted = userBuilder.questionsPosted;
        this.commentsAdded = userBuilder.commentsAdded;
        this.rating = userBuilder.rating;
        this.bookMarked = userBuilder.bookMarked;
        this.categoriesOfInterest = userBuilder.categoriesOfInterest;
    }

    @Setter
    public static class UserBuilder {
        private String userId;
        private List<Question> questionsPosted;
        private List<Comment> commentsAdded;
        private int rating;
        private List<Question> bookMarked;
        private List<Category> categoriesOfInterest;

        public UserBuilder() {
        }

        public User build() {
            return new User(this);
        }

    }
}
