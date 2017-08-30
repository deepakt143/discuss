package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Deepak Thakur
 */

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "points")
    private int points;

}
