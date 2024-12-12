package com.AmigoSecreto.ApiAmigoSecreto.services;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import com.AmigoSecreto.ApiAmigoSecreto.entities.Matches;
import com.AmigoSecreto.ApiAmigoSecreto.entities.Users;
import com.AmigoSecreto.ApiAmigoSecreto.exceptions.NotFoundException;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.GroupsRespository;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.MatchsRespository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.*;

@Service
public class MatchesServices {


    private final MatchsRespository matchsRespository;
    private final GroupsRespository groupsRespository;

    public MatchesServices(MatchsRespository matchsRespository, GroupsRespository groupsRespository) {
        this.matchsRespository = matchsRespository;
        this.groupsRespository = groupsRespository;
    }


    //GERAR OS MATCHES
    public List<Matches> generateMatches(UUID groupId) {
        Groups group = groupsRespository.findById(groupId).orElseThrow(NotFoundException::new);
        List<Users> users = group.getUsers();
        //VERIFFICAR SE A LISTA DE USUARIOS TEM MAIS DE DOIS ELEMENTOS
        if(users.size() < 2){
            throw new RuntimeException("NEED TWO USERS");
        }
        //FAZENDO LISTA DE NOMES DOS USUARIOS
        List<String> namesUsers = new ArrayList<>();
        for(Users user : users){
            namesUsers.add(user.getName());
        }
        //EMBARALAHNDO A LISTA DE NOMES
        Collections.shuffle(namesUsers);

        //CONSTRUÇÃO DO MATCH DE FORMA CICLICA
        List<Matches> matches = new ArrayList<>();
        for(int i = 0; i < namesUsers.size(); i++){
            Matches match = new Matches();
            match.setGroupMatches(group);
            match.setGiver(namesUsers.get(i));
            match.setReceiver(namesUsers.get((i + 1) % namesUsers.size()));
            match.setDateMatches(LocalDate.now().toString());
            matches.add(match);
        }
        return matchsRespository.saveAll(matches);
    }
    //DELETAR MATCHE
    public void removeMatches(UUID matchId) {
        matchsRespository.deleteById(matchId);
    }

}
