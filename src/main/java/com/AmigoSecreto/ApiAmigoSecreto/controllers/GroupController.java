package com.AmigoSecreto.ApiAmigoSecreto.controllers;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import com.AmigoSecreto.ApiAmigoSecreto.services.GroupsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Groups")
public class GroupController {

    private final GroupsServices groupsServices;

    public GroupController(GroupsServices groupsServices) {
        this.groupsServices = groupsServices;
    }
    @PostMapping
    public ResponseEntity<Groups> groupAdd(@RequestBody Groups group) {
        Groups addGroup = groupsServices.addGroup(group);
       return ResponseEntity.status(HttpStatus.CREATED).body(addGroup);
    }
    @GetMapping
    public List<Groups> getAllGroups(){
        return groupsServices.getAllGroups();
    }
}
