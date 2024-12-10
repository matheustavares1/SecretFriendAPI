package com.AmigoSecreto.ApiAmigoSecreto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_users")
public class Users {

    //CONECTA USER AO GROUP
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups groupId;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private Integer phone;



}
