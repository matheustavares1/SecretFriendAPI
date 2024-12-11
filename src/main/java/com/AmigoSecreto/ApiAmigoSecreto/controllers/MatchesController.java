package com.AmigoSecreto.ApiAmigoSecreto.controllers;

import com.AmigoSecreto.ApiAmigoSecreto.entities.Matches;
import com.AmigoSecreto.ApiAmigoSecreto.services.MatchesServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Matches")
public class MatchesController {



    private final MatchesServices matchesServices;

    public MatchesController(MatchesServices matchesServices) {
        this.matchesServices = matchesServices;
    }

    @DeleteMapping("/delete/{idMatches}")
    public void deleteMatches(@PathVariable UUID idMatches) {
        matchesServices.deleteMatches(idMatches);
    }

    @PostMapping("/random")
    public ResponseEntity<Matches> createRandomMatch() {
        Matches matches = matchesServices.pizeDraw();
        return ResponseEntity.ok(matches);
    }

}
