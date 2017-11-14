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
@Table(name = "person_question_likes")
@IdClass(PersonQuestionLikes.PersonQuestionLikesPK.class)
public class PersonQuestionLikes {

    @Data
    public static class PersonQuestionLikesPK implements Serializable {
        private Person person;
        private Question question;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "person_question_likes_person_id_fk"))
    private Person person;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "person_question_likes_question_id_fk"))
    private Question question;

    public PersonQuestionLikes() {
    }

    public Person getPerson() {
        return this.person;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PersonQuestionLikes)) return false;
        final PersonQuestionLikes other = (PersonQuestionLikes) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$person = this.person;
        final Object other$person = other.person;
        if (this$person == null ? other$person != null : !this$person.equals(other$person)) return false;
        final Object this$question = this.question;
        final Object other$question = other.question;
        if (this$question == null ? other$question != null : !this$question.equals(other$question)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $person = this.person;
        result = result * PRIME + ($person == null ? 0 : $person.hashCode());
        final Object $question = this.question;
        result = result * PRIME + ($question == null ? 0 : $question.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PersonQuestionLikes;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.PersonQuestionLikes(person=" + this.person + ", question=" + this.question + ")";
    }
}
