package com.discuss.core.dao.entity;

import javax.persistence.*;

/**
 *
 * @author Deepak Thakur
 *
 */

@Entity
@Table(name = "user_question_likes")
public class UserQuestionLikes {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_question_likes_user_id_fk"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "user_question_likes_question_id_fk"))
    private Question question;

    public UserQuestionLikes() {
    }

    public User getUser() {
        return this.user;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UserQuestionLikes)) return false;
        final UserQuestionLikes other = (UserQuestionLikes) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$user = this.user;
        final Object other$user = other.user;
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$question = this.question;
        final Object other$question = other.question;
        if (this$question == null ? other$question != null : !this$question.equals(other$question)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $user = this.user;
        result = result * PRIME + ($user == null ? 0 : $user.hashCode());
        final Object $question = this.question;
        result = result * PRIME + ($question == null ? 0 : $question.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserQuestionLikes;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.UserQuestionLikes(user=" + this.user + ", question=" + this.question + ")";
    }
}
