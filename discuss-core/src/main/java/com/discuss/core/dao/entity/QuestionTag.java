package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Deepak Thakur
 *
 */

@Data
@Entity
@Table(name = "question_tag")
@IdClass(QuestionTag.QuestionTagPK.class)
public class QuestionTag {

    @Data
    public static class QuestionTagPK implements Serializable {
        private Question question;
        private Tag tag;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "question_tag_question_id_fk"))
    private Question question;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "question_tag_tag_id_fk"))
    private Tag tag;
}
