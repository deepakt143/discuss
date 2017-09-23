package com.discuss.datatypes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


public class Comment implements Serializable{
    private int commentId;
    private String text;
    private int imageId;
    private int likes;
    private int views;
    private int userId;                        /*   posted by whom    */
    private String userName;                      /*   posted by whom    */

    public int getCommentId() {
        return commentId;
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

    private Comment(CommentBuilder commentBuilder) {
        this.commentId = commentBuilder.commentId;
        this.text = commentBuilder.text;
        this.imageId = commentBuilder.imageId;
        this.likes = commentBuilder.likes;
        this.views = commentBuilder.views;
        this.userId = commentBuilder.userId;
        this.userName = commentBuilder.userName;
    }

    public static class CommentBuilder {
        private int commentId;
        private String text;
        private int imageId;
        private int likes;
        private int views;
        private int userId;                        /*   posted by whom    */
        private String userName;                      /*   posted by whom    */
        public CommentBuilder() {
        }
        public Comment build() {
            return new Comment(this);
        }

        public CommentBuilder setCommentId(final int commentId) {
            this.commentId = commentId;
            return this;
        }
        public CommentBuilder setText(final String text) {
            this.text = text;
            return this;
        }
        public CommentBuilder setImageIds(final int imageId) {
            this.imageId = imageId;
            return this;
        }
        public CommentBuilder setLikes(final int likes) {
            this.likes = likes;
            return this;
        }
        public CommentBuilder setViews(final int views) {
            this.views = views;
            return this;
        }
        public CommentBuilder setUserId(final int userId) {
            this.userId = userId;
            return this;
        }
        public CommentBuilder setUserName(final String userName) {
            this.userName = userName;
            return this;
        }
    }


}
