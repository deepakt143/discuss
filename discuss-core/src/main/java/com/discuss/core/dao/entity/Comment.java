package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author Deepak Thakur
 *
 */
@Entity
@Table(name = "comment")
@SequenceGenerator(name = "comment_id_seq_gen", sequenceName = "comment_id_seq", allocationSize = 1)
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq_gen")
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "likes")
    private int likes;

    @Column(name = "views")
    private int views;

    @Column(name = "upvotes")
    private int upvotes;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "text")
    private String text;

    @Column(name = "image_id")
    private String imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "comment_question_id_fk"))
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "comment_person_id_fk"))
    private Person person;

    public Comment() {
    }
}
