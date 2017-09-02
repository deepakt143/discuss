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
@Table(name = "user_question_likes")
public class UserQuestionLikes {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_question_likes_user_id_fk"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "user_question_likes_question_id_fk"))
    private Question question;
}
