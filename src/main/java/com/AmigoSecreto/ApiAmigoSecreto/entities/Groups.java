package com.AmigoSecreto.ApiAmigoSecreto.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_groups")
public class Groups {

    @OneToMany(mappedBy = "groupId")
    private List<Users> users;

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
}
