package com.discuss.core.dao.entity;

import com.discuss.datatypes.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Optional;

/**
 *
 * @author Deepak Thakur
 *
 */

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

    public Tag() {
    }

    public int getTagId() {
        return this.tagId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPopularity() {
        return this.popularity;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Tag)) return false;
        final Tag other = (Tag) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.tagId != other.tagId) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.description;
        final Object other$description = other.description;
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (this.popularity != other.popularity) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.tagId;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 0 : $name.hashCode());
        final Object $description = this.description;
        result = result * PRIME + ($description == null ? 0 : $description.hashCode());
        result = result * PRIME + this.popularity;
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Tag;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.Tag(tagId=" + this.tagId + ", name=" + this.name + ", description=" + this.description + ", popularity=" + this.popularity + ")";
    }

    public static Optional<Category> getCategoryForTag(Tag tag) {
        if(null == tag)
            return Optional.empty();
        return Category.findByName(tag.getName());
    }
}
