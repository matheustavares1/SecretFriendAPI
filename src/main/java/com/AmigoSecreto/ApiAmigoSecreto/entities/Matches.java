package com.AmigoSecreto.ApiAmigoSecreto.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "tb_matches")
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idMatches;
    private String dateMatches;
    private String giver;
    private String receiver;


    @ManyToOne
    @JoinColumn(name = "groups_id")
    @JsonBackReference
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


    public void setGroupMatches(Groups groupMatches) {
        this.groupMatches = groupMatches;
    }

    public void setGiver(String giver) {
        this.giver = giver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public UUID getIdMatches() {
        return idMatches;
    }

    public String getDateMatches() {
        return dateMatches;
    }

    public String getGiver() {
        return giver;
    }

    public String getReceiver() {
        return receiver;
    }

    public Groups getGroupMatches() {
        return groupMatches;
    }
}
