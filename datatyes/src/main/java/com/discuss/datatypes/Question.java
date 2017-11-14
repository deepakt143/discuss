package com.discuss.datatypes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


public class Question implements Serializable {
    private int questionId;
    private String text;
    private String imageUrl;
    //private List<String> commentIds;
    private int likes;
    private int views;
    private int personId;                        /*   posted by whom    */
    private String personName;                      /*   posted by whom    */
    private String difficulty;
    private boolean liked;
    private boolean bookmarked;

    public int getQuestionId() {
        return questionId;
    }
    public String getText() {
        return text;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public int getLikes() {
        return likes;
    }
    public int getViews() {
        return views;
    }
    public int getPersonId() {
        return personId;
    }
    public String getPersonName() {
        return personName;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public boolean isLiked() {
        return liked;
    }
    public boolean isBookmarked() {
        return bookmarked;
    }
    public void setLiked(final boolean liked) {
        this.liked = liked;
    }
    public void setBookmarked(final boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
    private Question(QuestionBuilder questionBuilder) {
        this.questionId = questionBuilder.questionId;
        this.text = questionBuilder.text;
        this.imageUrl = questionBuilder.imageUrl;
       // this.commentIds = questionBuilder.commentIds;
        this.likes = questionBuilder.likes;
        this.views = questionBuilder.views;
        this.personId = questionBuilder.personId;
        this.personName = questionBuilder.personName;
    }
    public static class QuestionBuilder {
        private int questionId;
        private String text;
        private String imageUrl;
       // private List<String> commentIds;
        private int likes;
        private int views;
        private int personId;                        /*   posted by whom    */
        private String personName;                      /*   posted by whom    */
        private String difficulty;
        private boolean liked;

        public QuestionBuilder() {
        }

        public QuestionBuilder setQuestionId(final int questionId) {
            this.questionId = questionId;
            return this;
        }
        public QuestionBuilder setText(final String text) {
            this.text = text;
            return this;
        }
        public QuestionBuilder setImageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }
       /* public QuestionBuilder setCommentIds(final List<String> commentIds) {
            this.commentIds = commentIds;
            return this;
        }*/
        public QuestionBuilder setLikes(final int likes) {
            this.likes = likes;
            return  this;
        }
        public QuestionBuilder setViews(final int views) {
            this.views = views;
            return this;
        }
        public QuestionBuilder setPersonId(final int personId) {
            this.personId = personId;
            return this;
        }
        public QuestionBuilder setPersonName(final String personName) {
            this.personName = personName;
            return this;
        }
        public QuestionBuilder setDifficulty(final String difficulty) {
            this.difficulty = difficulty;
            return this;
        }
        public QuestionBuilder setLiked(final boolean liked) {
            this.liked = liked;
            return this;
        }
        public Question build() {
            return new Question(this);
        }
    }
}
