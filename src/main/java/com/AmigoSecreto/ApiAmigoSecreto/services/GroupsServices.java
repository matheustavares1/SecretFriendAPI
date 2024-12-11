package com.AmigoSecreto.ApiAmigoSecreto.services;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import com.AmigoSecreto.ApiAmigoSecreto.repositories.GroupsRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsServices {

    private final GroupsRespository groupsRespository;

    public GroupsServices(GroupsRespository groupsRespository) {
        this.groupsRespository = groupsRespository;
    }

    public Groups addGroup(Groups group) {
        return groupsRespository.save(group);
    }
    public List<Groups> getAllGroups() {
        return groupsRespository.findAll();
    }
}
