package com.discuss.datatypes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Deepak Thakur
 */
public class Comment implements Serializable{
    private int commentId;
    private String text;
    private String imageUrl;
    private int likes;
    private int views;
    private int personId;                        /*   posted by whom    */
    private String personName;                      /*   posted by whom    */
    private boolean liked;

    public int getCommentId() {
        return commentId;
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
    public boolean isLiked() {
        return liked;
    }
    public void setLiked(final boolean liked) {
        this.liked = liked;
    }

    private Comment(CommentBuilder commentBuilder) {
        this.commentId = commentBuilder.commentId;
        this.text = commentBuilder.text;
        this.imageUrl = commentBuilder.imageUrl;
        this.likes = commentBuilder.likes;
        this.views = commentBuilder.views;
        this.personId = commentBuilder.personId;
        this.personName = commentBuilder.personName;
        this.liked = commentBuilder.liked;
    }

    public static class CommentBuilder {
        private int commentId;
        private String text;
        private String imageUrl;
        private int likes;
        private int views;
        private int personId;                        /*   posted by whom    */
        private String personName;                      /*   posted by whom    */
        private boolean liked;
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
        public CommentBuilder setImageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
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
        public CommentBuilder setPersonId(final int personId) {
            this.personId = personId;
            return this;
        }
        public CommentBuilder setPersonName(final String personName) {
            this.personName = personName;
            return this;
        }
        public CommentBuilder setLiked(final boolean liked) {
            this.liked = liked;
            return this;
        }
    }


}
