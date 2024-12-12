package com.AmigoSecreto.ApiAmigoSecreto.controllers;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Matches;
import com.AmigoSecreto.ApiAmigoSecreto.services.MatchesServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Matches")
public class MatchesController {



    private final MatchesServices matchesServices;

    public MatchesController(MatchesServices matchesServices) {
        this.matchesServices = matchesServices;
    }


    @PostMapping("/{groupId}/gernerate-matches")
    public ResponseEntity<List<Matches>> generateMatches(@PathVariable UUID groupId) {
        return ResponseEntity.ok(matchesServices.generateMatches(groupId));
    }

    @DeleteMapping("{idMatches}")
    public void deleteMatches(@PathVariable UUID idMatches) {
        matchesServices.removeMatches(idMatches);
    }

}
