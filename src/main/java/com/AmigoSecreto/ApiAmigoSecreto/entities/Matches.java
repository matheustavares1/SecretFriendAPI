package com.AmigoSecreto.ApiAmigoSecreto.entities;
//CLASSE DE SORTEIO

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_matches")
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idMatches;
    private String dateMatches;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userMatches;

    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups groupMatches;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private Users friend;

    public Matches (){
        this.dateMatches = LocalDate.now().toString();
    }
}
