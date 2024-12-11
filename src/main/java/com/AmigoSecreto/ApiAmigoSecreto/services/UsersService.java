package com.AmigoSecreto.ApiAmigoSecreto.services;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import com.AmigoSecreto.ApiAmigoSecreto.entities.Users;
import com.AmigoSecreto.ApiAmigoSecreto.exceptions.NotFoundException;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.GroupsRespository;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.UsersRespository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

    private final UsersRespository usersRespository;
    private final GroupsRespository groupsRespository;

    public UsersService(UsersRespository usersRespository, GroupsRespository groupsRespository) {
        this.usersRespository = usersRespository;
        this.groupsRespository = groupsRespository;
    }

    public Users addUserGroup( Users user, UUID group) {
        Groups groupsId = groupsRespository.findById(group)
                .orElseThrow(NotFoundException::new);
        user.setGroupId(groupsId);
       return usersRespository.save(user);
    }

    public List<Users> getAllUsers() {
        return usersRespository.findAll();
    }
    public void deleteUserId(UUID id) {
        usersRespository.deleteById(id);
    }
}
