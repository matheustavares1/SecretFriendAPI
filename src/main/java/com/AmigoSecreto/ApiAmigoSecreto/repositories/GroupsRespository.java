package com.AmigoSecreto.ApiAmigoSecreto.repositories;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.UUID;

public interface GroupsRespository extends JpaRepository<Groups, UUID> {
    @Query("SELECT g.idGroup from Groups g order by RANDOM() limit 1 ")
    List<UUID> findByIdGroup();


}
