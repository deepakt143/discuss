package com.discuss.core.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author Deepak Thakur
 *
 */

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "upvotes")
    private int likes;

    @Column(name = "views")
    private int views;

    @Column(name = "difficulty")
    private int difficulty;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "text")
    private String text;

    @Column(name = "image_id")
    private int imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
    private User user;

    public Question() {
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getViews() {
        return this.views;
    }

    public int getDifficulty() {
        return this.difficulty;
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

    public User getUser() {
        return this.user;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
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

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Question)) return false;
        final Question other = (Question) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.questionId != other.questionId) return false;
        if (this.likes != other.likes) return false;
        if (this.views != other.views) return false;
        if (this.difficulty != other.difficulty) return false;
        final Object this$timestamp = this.timestamp;
        final Object other$timestamp = other.timestamp;
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        final Object this$text = this.text;
        final Object other$text = other.text;
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        if (this.imageId != other.imageId) return false;
        final Object this$user = this.user;
        final Object other$user = other.user;
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.questionId;
        result = result * PRIME + this.likes;
        result = result * PRIME + this.views;
        result = result * PRIME + this.difficulty;
        final Object $timestamp = this.timestamp;
        result = result * PRIME + ($timestamp == null ? 0 : $timestamp.hashCode());
        final Object $text = this.text;
        result = result * PRIME + ($text == null ? 0 : $text.hashCode());
        result = result * PRIME + this.imageId;
        final Object $user = this.user;
        result = result * PRIME + ($user == null ? 0 : $user.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Question;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.Question(questionId=" + this.questionId + ", likes=" + this.likes + ", views=" + this.views + ", difficulty=" + this.difficulty + ", timestamp=" + this.timestamp + ", text=" + this.text + ", imageId=" + this.imageId + ", user=" + this.user + ")";
    }
}
