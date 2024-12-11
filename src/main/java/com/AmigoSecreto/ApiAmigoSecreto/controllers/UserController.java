package com.AmigoSecreto.ApiAmigoSecreto.controllers;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Users;
import com.AmigoSecreto.ApiAmigoSecreto.services.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/Users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/{idGroup}")
    public Users addUser(@RequestBody Users user, @PathVariable UUID idGroup) {
        return usersService.addUserGroup(user, idGroup);

    }
    @GetMapping("/")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public void deleteUserId(@PathVariable UUID id) {
        usersService.deleteUserId(id);
    }

}
