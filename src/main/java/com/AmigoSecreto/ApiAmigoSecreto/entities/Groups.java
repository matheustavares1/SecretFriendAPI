package com.AmigoSecreto.ApiAmigoSecreto.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_groups")
public class Groups {

    @OneToMany(mappedBy = "groupId")
    @JsonManagedReference
    private List<Users> users = new ArrayList<>();

    @OneToMany(mappedBy = "groupMatches")
    @JsonManagedReference
    private List<Matches> groupMatches = new ArrayList<>();

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

    public Groups(){
    }

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

}
