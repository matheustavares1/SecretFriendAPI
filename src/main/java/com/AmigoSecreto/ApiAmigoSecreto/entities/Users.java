package com.AmigoSecreto.ApiAmigoSecreto.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_users")
public class Users {

    //CONECTA USER AO GROUP
    @Setter
    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private Groups groupId;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String phone;

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
