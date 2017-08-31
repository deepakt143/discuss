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
@Table(name = "user_tag_interests")
public class UserTagInterests {

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_tag_interests_user_id_fk"))
    private User user;

    @OneToOne
    @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "user_tag_interests_tag_id_fk"))
    private Question Tag;
}
