package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.security.Timestamp;

/**
 *
 * @author Deepak Thakur
 *
 */
@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
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
    private int imageId;

    @ManyToOne
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "comment_question_id_fk"))
    private Question question;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "comment_user_id_fk"))
    private User ownerUser;
}
