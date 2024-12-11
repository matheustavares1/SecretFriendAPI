package com.AmigoSecreto.ApiAmigoSecreto.entities;

import jakarta.persistence.*;


import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@Entity
@Table(name = "tb_groups")
public class Groups {

    @OneToMany(mappedBy = "groupId")
    private List<Users> users;

    @OneToMany(mappedBy = "groupMatches")
    private List<Matches> groupMatches;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idGroup;
    @Column(name = "name_group")
    private String nameGroup;
    @Column(name = "createdon")
    private String createdOn;
    @Column(name = "event_date")
    private String eventDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.WAITING;

    public Groups (String createdOn){
        this.createdOn = LocalDate.now().toString();
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public void setIdGroup(UUID idGroup) {
        this.idGroup = idGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setGroupMatches(List<Matches> groupMatches) {
        this.groupMatches = groupMatches;
    }

    public List<Users> getUsers() {
        return users;
    }

    public List<Matches> getGroupMatches() {
        return groupMatches;
    }

    public UUID getIdGroup() {
        return idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getEventDate() {
        return eventDate;
    }

    public Status getStatus() {
        return status;
    }
}
