package com.example.dice_minigame.controller;

import com.example.dice_minigame.Entity.Achievements;
import com.example.dice_minigame.Entity.Player;
import com.example.dice_minigame.Entity.Team;
import com.example.dice_minigame.request.AchievementsRequest;
import com.example.dice_minigame.request.PlayerRequest;
import com.example.dice_minigame.request.TeamRequest;
import com.example.dice_minigame.response.AchievementsResponse;
import com.example.dice_minigame.response.PlayerResponse;
import com.example.dice_minigame.response.TeamResponse;
import com.example.dice_minigame.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping()
    public List<PlayerResponse> getAllPlayers(@RequestParam(required = false) String userName){
        List<Player> players = playerService.getAllPlayers(userName);

        List<PlayerResponse> playersResponse = new ArrayList<>();
        players.forEach(player -> {
            playersResponse.add(new PlayerResponse(player));
        });
        return playersResponse;
    }

    @GetMapping("/{userName}")
    public List<PlayerResponse> getPlayerByName(@RequestParam(required = false) String userName){
        List<Player> players = playerService.getPlayerByName(userName);

        List<PlayerResponse> playersResponse = new ArrayList<>();
        players.forEach(player -> {
            playersResponse.add(new PlayerResponse(player));
        });
        return playersResponse;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse addPlayer(@Valid @RequestBody PlayerRequest playerRequest)
    {

        Player savedPlayer = playerService.addPlayer(playerRequest);

        return new PlayerResponse(savedPlayer);

    }

    @DeleteMapping("/{playerId}")
    public void deletePlayer(@PathVariable long playerId){
        playerService.deletePlayer(playerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{teamId}/team")
    public PlayerResponse addPlayertoTeam(
            @PathVariable long teamId,
            @Valid @RequestBody PlayerRequest playerRequest
            ){
        return new PlayerResponse(playerService.addPlayerToTeam(teamId, playerRequest));
    }

    @GetMapping("/{teamId}/team")
    public List<PlayerResponse> getAllPlayersinTeam(@PathVariable long teamId){
        List<Player> players = playerService.getAllPlayersInTeam(teamId);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(int i=0; i < players.size(); i++){
            playerResponses.add(new PlayerResponse(players.get(i)));
        }
        return playerResponses;
    }

    @DeleteMapping("/{playerId}/team")
    public void deleteAllByTeamId(@PathVariable long teamId){
        playerService.deleteAllByTeamId(teamId);
    }

    @PutMapping("/{playerId}")
    public PlayerResponse updatePlayer(@PathVariable long playerId, @Valid @RequestBody PlayerRequest playerRequest){
        return new PlayerResponse(playerService.updatePlayer(playerId, playerRequest));
    }
}
