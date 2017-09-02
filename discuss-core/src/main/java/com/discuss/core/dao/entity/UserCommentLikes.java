package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * @author Deepak Thakur
 *
 */

@Data
@Entity
@Table(name = "user_comment_likes")
public class UserCommentLikes {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_comment_likes_user_id_fk"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", foreignKey = @ForeignKey(name = "user_comment_likes_comment_id_fk"))
    private Comment comment;
}
