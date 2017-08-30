package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Deepak Thakur
 *
 */
@Data
@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "upvotes")
    private int likes;

    @Column(name = "views")
    private int views;

    @Column(name = "difficulty")
    private int difficulty;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "text")
    private String text;

    @Column(name = "image_id")
    private String imageId;

    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
    private User user;
}
