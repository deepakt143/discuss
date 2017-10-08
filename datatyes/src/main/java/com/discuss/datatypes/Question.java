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
    private int imageId;
    //private List<String> commentIds;
    private int likes;
    private int views;
    private int userId;                        /*   posted by whom    */
    private String userName;                      /*   posted by whom    */
    private String difficulty;
    private boolean liked;

    public int getQuestionId() {
        return questionId;
    }
    public String getText() {
        return text;
    }
    public int getImageId() {
        return imageId;
    }
    public int getLikes() {
        return likes;
    }
    public int getViews() {
        return views;
    }
    public int getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public boolean isLiked() {
        return liked;
    }
    public void setLiked(final boolean liked) {
        this.liked = liked;
    }
    private Question(QuestionBuilder questionBuilder) {
        this.questionId = questionBuilder.questionId;
        this.text = questionBuilder.text;
        this.imageId = questionBuilder.imageId;
       // this.commentIds = questionBuilder.commentIds;
        this.likes = questionBuilder.likes;
        this.views = questionBuilder.views;
        this.userId = questionBuilder.userId;
        this.userName = questionBuilder.userName;
    }
    public static class QuestionBuilder {
        private int questionId;
        private String text;
        private int imageId;
       // private List<String> commentIds;
        private int likes;
        private int views;
        private int userId;                        /*   posted by whom    */
        private String userName;                      /*   posted by whom    */
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
        public QuestionBuilder setImageId(final int imageId) {
            this.imageId = imageId;
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
        public QuestionBuilder setUserId(final int userId) {
            this.userId = userId;
            return this;
        }
        public QuestionBuilder setUserName(final String userName) {
            this.userName = userName;
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
