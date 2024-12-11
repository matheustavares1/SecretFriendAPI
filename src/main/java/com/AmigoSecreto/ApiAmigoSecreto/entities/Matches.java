package com.AmigoSecreto.ApiAmigoSecreto.entities;
//CLASSE DE SORTEIO

import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Entity
@Table(name = "tb_matches")
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idMatches;
    private String dateMatches;
    private UUID IdFriend;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userMatches;

    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups groupMatches;

    public Matches (){
        this.dateMatches = LocalDate.now().toString();
    }

    public void setIdMatches(UUID idMatches) {
        this.idMatches = idMatches;
    }

    public void setDateMatches(String dateMatches) {
        this.dateMatches = dateMatches;
    }

    public void setUserMatches(Users userMatches) {
        this.userMatches = userMatches;
    }

    public void setGroupMatches(Groups groupMatches) {
        this.groupMatches = groupMatches;
    }

    public void setFriendId(Users friendId) {
      //  this.friendId = friendId;
    }

    public void setIdFriend(UUID idFriend) {
        IdFriend = idFriend;
    }

}
