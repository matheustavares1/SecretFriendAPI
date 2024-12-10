package com.AmigoSecreto.ApiAmigoSecreto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_groups")
public class Groups {

    @OneToMany(mappedBy = "groupId")
    private List<Users> users;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name_group")
    private String nameGroup;
    private String createdOn;
    @Column(name = "event_date")
    private String eventDate;
    private Status status;
}
