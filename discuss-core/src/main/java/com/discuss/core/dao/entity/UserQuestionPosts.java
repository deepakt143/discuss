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
@Table(name = "user_question_posts")
public class UserQuestionPosts {

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_question_posts_user_id_fk"))
    private User user;

    @OneToOne
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "user_question_posts_question_id_fk"))
    private Question question;
}
