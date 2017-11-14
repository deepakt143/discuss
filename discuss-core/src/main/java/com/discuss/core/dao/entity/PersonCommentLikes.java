package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Deepak Thakur
 *
 */

@Entity
@Table(name = "person_comment_likes")
@IdClass(PersonCommentLikes.PersonCommentLikesPK.class)
public class PersonCommentLikes {

    @Data
    public static class PersonCommentLikesPK implements Serializable {
        private Person person;
        private Comment comment;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "person_comment_likes_person_id_fk"))
    private Person person;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", foreignKey = @ForeignKey(name = "person_comment_likes_comment_id_fk"))
    private Comment comment;

    public PersonCommentLikes() {
    }

    public Person getPerson() {
        return this.person;
    }

    public Comment getComment() {
        return this.comment;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PersonCommentLikes)) return false;
        final PersonCommentLikes other = (PersonCommentLikes) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$person = this.person;
        final Object other$person = other.person;
        if (this$person == null ? other$person != null : !this$person.equals(other$person)) return false;
        final Object this$comment = this.comment;
        final Object other$comment = other.comment;
        if (this$comment == null ? other$comment != null : !this$comment.equals(other$comment)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $person = this.person;
        result = result * PRIME + ($person == null ? 0 : $person.hashCode());
        final Object $comment = this.comment;
        result = result * PRIME + ($comment == null ? 0 : $comment.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PersonCommentLikes;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.PersonCommentLikes(person=" + this.person + ", comment=" + this.comment + ")";
    }
}
