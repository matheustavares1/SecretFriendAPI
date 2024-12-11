package com.AmigoSecreto.ApiAmigoSecreto.repositories;


import com.AmigoSecreto.ApiAmigoSecreto.entities.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchsRespository extends JpaRepository<Matches, UUID> {



}
