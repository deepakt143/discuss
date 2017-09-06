package com.discuss.core.dao.entity;

import javax.persistence.*;

/**
 *
 * @author Deepak Thakur
 *
 */

@Entity
@Table(name = "user_tag_interests")
public class UserTagInterests {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_tag_interests_user_id_fk"))
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "user_tag_interests_tag_id_fk"))
    private Question Tag;

    public UserTagInterests() {
    }

    public User getUser() {
        return this.user;
    }

    public Question getTag() {
        return this.Tag;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTag(Question Tag) {
        this.Tag = Tag;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UserTagInterests)) return false;
        final UserTagInterests other = (UserTagInterests) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$user = this.user;
        final Object other$user = other.user;
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$Tag = this.Tag;
        final Object other$Tag = other.Tag;
        if (this$Tag == null ? other$Tag != null : !this$Tag.equals(other$Tag)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $user = this.user;
        result = result * PRIME + ($user == null ? 0 : $user.hashCode());
        final Object $Tag = this.Tag;
        result = result * PRIME + ($Tag == null ? 0 : $Tag.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserTagInterests;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.UserTagInterests(user=" + this.user + ", Tag=" + this.Tag + ")";
    }
}
