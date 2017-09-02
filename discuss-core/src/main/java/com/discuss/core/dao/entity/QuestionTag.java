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
@Table(name = "question_tag")
public class QuestionTag {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "question_tag_question_id_fk"))
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "question_tag_tag_id_fk"))
    private Tag tag;
}
