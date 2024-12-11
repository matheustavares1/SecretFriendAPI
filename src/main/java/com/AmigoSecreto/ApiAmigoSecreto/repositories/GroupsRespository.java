package com.AmigoSecreto.ApiAmigoSecreto.repositories;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupsRespository extends JpaRepository<Groups, UUID> {

}
