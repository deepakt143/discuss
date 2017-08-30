package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Deepak Thakur
 *
 */

@Data
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Column(name = "tag_id")
    private int tagId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "popularity")
    private int popularity;
}
