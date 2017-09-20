package com.discuss.core.dao.entity;

import javax.persistence.*;
import java.security.Timestamp;

/**
 *
 * @author Deepak Thakur
 *
 */
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "likes")
    private int likes;

    @Column(name = "views")
    private int views;

    @Column(name = "upvotes")
    private int upvotes;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "text")
    private String text;

    @Column(name = "image_id")
    private int imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "comment_question_id_fk"))
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "comment_user_id_fk"))
    private User user;

    public Comment() {
    }

    public int getCommentId() {
        return this.commentId;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getViews() {
        return this.views;
    }

    public int getUpvotes() {
        return this.upvotes;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public String getText() {
        return this.text;
    }

    public int getImageId() {
        return this.imageId;
    }

    public Question getQuestion() {
        return this.question;
    }

    public User getUser() {
        return this.user;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Comment)) return false;
        final Comment other = (Comment) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.commentId != other.commentId) return false;
        if (this.likes != other.likes) return false;
        if (this.views != other.views) return false;
        if (this.upvotes != other.upvotes) return false;
        final Object this$timestamp = this.timestamp;
        final Object other$timestamp = other.timestamp;
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        final Object this$text = this.text;
        final Object other$text = other.text;
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        if (this.imageId != other.imageId) return false;
        final Object this$question = this.question;
        final Object other$question = other.question;
        if (this$question == null ? other$question != null : !this$question.equals(other$question)) return false;
        final Object this$user = this.user;
        final Object other$user = other.user;
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.commentId;
        result = result * PRIME + this.likes;
        result = result * PRIME + this.views;
        result = result * PRIME + this.upvotes;
        final Object $timestamp = this.timestamp;
        result = result * PRIME + ($timestamp == null ? 0 : $timestamp.hashCode());
        final Object $text = this.text;
        result = result * PRIME + ($text == null ? 0 : $text.hashCode());
        result = result * PRIME + this.imageId;
        final Object $question = this.question;
        result = result * PRIME + ($question == null ? 0 : $question.hashCode());
        final Object $user = this.user;
        result = result * PRIME + ($user == null ? 0 : $user.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Comment;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.Comment(commentId=" + this.commentId + ", likes=" + this.likes + ", views=" + this.views + ", upvotes=" + this.upvotes + ", timestamp=" + this.timestamp + ", text=" + this.text + ", imageId=" + this.imageId + ", question=" + this.question + ", user=" + this.user + ")";
    }
}
