package com.discuss.core.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Deepak Thakur
 *
 */

@Entity
@Table(name = "person_tag_interests")
@IdClass(PersonTagInterests.PersonTagInterestsPK.class)
public class PersonTagInterests {

    @Data
    public static class PersonTagInterestsPK implements Serializable {
        private Person person;
        private Tag tag;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "person_tag_interests_person_id_fk"))
    private Person person;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "person_tag_interests_tag_id_fk"))
    private Tag tag;

    public PersonTagInterests() {
    }

    public Person getPerson() {
        return this.person;
    }

    public Tag getTag() {
        return this.tag;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setTag(Tag Tag) {
        this.tag = Tag;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PersonTagInterests)) return false;
        final PersonTagInterests other = (PersonTagInterests) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$person = this.person;
        final Object other$person = other.person;
        if (this$person == null ? other$person != null : !this$person.equals(other$person)) return false;
        final Object this$Tag = this.tag;
        final Object other$Tag = other.tag;
        if (this$Tag == null ? other$Tag != null : !this$Tag.equals(other$Tag)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $person = this.person;
        result = result * PRIME + ($person == null ? 0 : $person.hashCode());
        final Object $Tag = this.tag;
        result = result * PRIME + ($Tag == null ? 0 : $Tag.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PersonTagInterests;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.PersonTagInterests(person=" + this.person + ", Tag=" + this.tag + ")";
    }
}
