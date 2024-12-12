package com.AmigoSecreto.ApiAmigoSecreto.controllers;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import com.AmigoSecreto.ApiAmigoSecreto.services.GroupsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @DeleteMapping("/{idGroups}")
    public void removeGroup(@PathVariable UUID idGroups) {
        groupsServices.removeGroup(idGroups);
    }
}
