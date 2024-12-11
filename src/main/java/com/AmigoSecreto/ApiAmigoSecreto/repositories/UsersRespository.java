package com.AmigoSecreto.ApiAmigoSecreto.repositories;


import com.AmigoSecreto.ApiAmigoSecreto.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRespository extends JpaRepository<Users, UUID> {

}
