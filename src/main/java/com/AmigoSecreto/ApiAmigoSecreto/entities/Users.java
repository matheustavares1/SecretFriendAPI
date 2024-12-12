package com.AmigoSecreto.ApiAmigoSecreto.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name = "tb_users")
public class Users {

    //CONECTA USER AO GROUP
    @ManyToOne
    @JoinColumn(name = "id_group")
    @JsonBackReference
    private Groups groupId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;


    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public void setId(Integer id) {
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

    public void setFriendId(List<Matches> friendId) {
      //  this.friendId = friendId;
    }


    public Groups getGroupId() {
        return groupId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
