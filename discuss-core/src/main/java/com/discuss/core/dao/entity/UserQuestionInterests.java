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
@Table(name = "user_question_interests")
public class UserQuestionInterests {

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_question_interests_user_id_fk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "user_question_interests_question_id_fk"))
    private Question question;
}
