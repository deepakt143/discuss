package com.discuss.core.dao.entity;

import javax.persistence.*;

/**
 *
 * @author Deepak Thakur
 */

@Entity
@Table(name = "person")
@SequenceGenerator(name = "person_id_seq_gen", sequenceName = "person_id_seq", allocationSize = 1)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq_gen")
    @Column(name = "person_id")
    private int personId;

    @Column(name = "name")
    private String name;

    @Column(name = "points")
    private int points;

    public Person() {
    }

    public int getPersonId() {
        return this.personId;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.personId != other.personId) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.points != other.points) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.personId;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 0 : $name.hashCode());
        result = result * PRIME + this.points;
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Person;
    }

    public String toString() {
        return "com.discuss.core.dao.entity.Person(personId=" + this.personId + ", name=" + this.name + ", points=" + this.points + ")";
    }
}
