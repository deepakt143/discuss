package com.discuss.core.dao.entity;


import javax.persistence.*;

/**
 *
 * @author Deepak Thakur
 *
 */

@Entity
@Table(name = "user_question_posts")
public class UserQuestionPosts {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_question_posts_user_id_fk"))
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "user_question_posts_question_id_fk"))
    private Question question;

    public UserQuestionPosts() {
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
        if (!(o instanceof UserQuestionPosts)) return false;
        final UserQuestionPosts other = (UserQuestionPosts) o;
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
        return other instanceof UserQuestionPosts;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.UserQuestionPosts(user=" + this.user + ", question=" + this.question + ")";
    }
}
