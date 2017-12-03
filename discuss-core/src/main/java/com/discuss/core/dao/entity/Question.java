package com.discuss.core.dao.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author Deepak Thakur
 *
 */

@Entity
@Table(name = "question")
@SequenceGenerator(name = "question_id_seq_gen", sequenceName = "question_id_seq", allocationSize = 1)
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_seq_gen")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name="person_question_posts",
        joinColumns = @JoinColumn( name="question_id"),
        inverseJoinColumns = @JoinColumn( name="person_id")
    )
    private Person person;

    public Question() {
    }
}
