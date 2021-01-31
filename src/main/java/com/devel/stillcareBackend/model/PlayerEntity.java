package com.devel.stillcareBackend.model;

import javax.persistence.*;

@Entity
@Table(name = "PLAYER", schema = "ELASRIM", catalog = "")
public class PlayerEntity {
    private long id;
    private String name;
    private Integer num;
    private String position;
    private long teamId;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "NUM")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "POSITION")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "TEAM_ID")
    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerEntity that = (PlayerEntity) o;

        if (id != that.id) return false;
        if (teamId != that.teamId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (int) (teamId ^ (teamId >>> 32));
        return result;
    }
}
