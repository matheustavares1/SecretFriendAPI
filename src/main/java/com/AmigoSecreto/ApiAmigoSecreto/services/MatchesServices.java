package com.AmigoSecreto.ApiAmigoSecreto.services;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import com.AmigoSecreto.ApiAmigoSecreto.entities.Matches;
import com.AmigoSecreto.ApiAmigoSecreto.entities.Users;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.GroupsRespository;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.MatchsRespository;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.UsersRespository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class MatchesServices {

    private final UsersRespository usersRespository;
    private final MatchsRespository matchsRespository;
    private final GroupsRespository groupsRespository;

    public MatchesServices(UsersRespository usersRespository, MatchsRespository matchsRespository, GroupsRespository groupsRespository) {
        this.usersRespository = usersRespository;
        this.matchsRespository = matchsRespository;
        this.groupsRespository = groupsRespository;
    }

    public Matches pizeDraw() {
        //PEGAR O GRUPO
        List<UUID> groupId = groupsRespository.findByIdGroup();
        //VERIFICAR O GRUPO
        Groups groups1 = groupsRespository.findById(groupId.get(0))
                .orElseThrow(IllegalArgumentException::new);

        //CRIANDO A LISTA COM OS DOIS USERS ALEATORIOS
        List<UUID> userIds = usersRespository.findTwoRandomIds();
        //VERIFICANDO SE A LISTA TEM  2 ELEMENTOS
        if (userIds.size() < 2) {
           throw new IllegalArgumentException("Need to have two id");
        }

        //VERIFICAÇÃO DE ID NOS INDICIES DA LISTA
        Users user1 = usersRespository.findById(userIds.get(0))
                .orElseThrow(IllegalArgumentException::new);

        //CONSTRUINDO MEU MATCH
        Matches matches = new Matches();
        matches.setUserMatches(user1); //QUEM TA TIRANDO
        matches.setIdFriend(userIds.get(1)); //QUEM TA SENDO SORTEADO
        matches.setDateMatches(LocalDate.now().toString());
        matches.setGroupMatches(groups1);

        return matchsRespository.save(matches);
    }

    public void deleteMatches(UUID matchId) {
        matchsRespository.deleteById(matchId);
    }




}
