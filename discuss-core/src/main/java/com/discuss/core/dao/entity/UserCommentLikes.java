package com.discuss.core.dao.entity;

import javax.persistence.*;

/**
 *
 * @author Deepak Thakur
 *
 */

@Entity
@Table(name = "user_comment_likes")
public class UserCommentLikes {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_comment_likes_user_id_fk"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", foreignKey = @ForeignKey(name = "user_comment_likes_comment_id_fk"))
    private Comment comment;

    public UserCommentLikes() {
    }

    public User getUser() {
        return this.user;
    }

    public Comment getComment() {
        return this.comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UserCommentLikes)) return false;
        final UserCommentLikes other = (UserCommentLikes) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$user = this.user;
        final Object other$user = other.user;
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$comment = this.comment;
        final Object other$comment = other.comment;
        if (this$comment == null ? other$comment != null : !this$comment.equals(other$comment)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $user = this.user;
        result = result * PRIME + ($user == null ? 0 : $user.hashCode());
        final Object $comment = this.comment;
        result = result * PRIME + ($comment == null ? 0 : $comment.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserCommentLikes;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.UserCommentLikes(user=" + this.user + ", comment=" + this.comment + ")";
    }
}
