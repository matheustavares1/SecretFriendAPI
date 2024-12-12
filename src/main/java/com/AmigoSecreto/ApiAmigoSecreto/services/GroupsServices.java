package com.AmigoSecreto.ApiAmigoSecreto.services;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.GroupsRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class GroupsServices {

    private final GroupsRespository groupsRespository;

    public GroupsServices(GroupsRespository groupsRespository) {
        this.groupsRespository = groupsRespository;
    }

    public Groups addGroup(Groups group) {
        group.setCreatedOn(LocalDate.now().toString());
        return groupsRespository.save(group);
    }
    public List<Groups> getAllGroups() {
        return groupsRespository.findAll();
    }
    public void removeGroup(UUID idGroup) {
        groupsRespository.deleteById(idGroup);
    }
}
