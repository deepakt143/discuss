package com.discuss.datatypes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Deepak Thakur
 */
@Getter
public class Person {
    private String personId;
    private List<Question> questionsPosted;
    private List<Comment> commentsAdded;
    private int rating;
    private List<Question> bookMarked;
    private List<Category> categoriesOfInterest;

    private Person(PersonBuilder userBuilder) {
        this.personId = userBuilder.personId;
        this.questionsPosted = userBuilder.questionsPosted;
        this.commentsAdded = userBuilder.commentsAdded;
        this.rating = userBuilder.rating;
        this.bookMarked = userBuilder.bookMarked;
        this.categoriesOfInterest = userBuilder.categoriesOfInterest;
    }

    @Setter
    public static class PersonBuilder {
        private String personId;
        private List<Question> questionsPosted;
        private List<Comment> commentsAdded;
        private int rating;
        private List<Question> bookMarked;
        private List<Category> categoriesOfInterest;

        public PersonBuilder() {
        }

        public Person build() {
            return new Person(this);
        }

    }
}
