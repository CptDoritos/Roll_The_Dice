package com.example.dice_minigame.service;

import com.example.dice_minigame.Entity.Achievements;
import com.example.dice_minigame.Entity.Player;
import com.example.dice_minigame.Entity.Team;
import com.example.dice_minigame.exception.ResourceNotFound;
import com.example.dice_minigame.repository.PlayerRepository;
import com.example.dice_minigame.repository.TeamRepository;
import com.example.dice_minigame.request.AchievementsRequest;
import com.example.dice_minigame.request.PlayerRequest;
import com.example.dice_minigame.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    public List<Player> getAllPlayers(String userNameParam){
        if(userNameParam == null || userNameParam.isEmpty())
            return (List<Player>) playerRepository.findAll();
        else {
            return (List<Player>) playerRepository.findAllByUserNameIgnoreCase(userNameParam);
        }
    }

    public Player addPlayer(PlayerRequest playerRequest)
    {
        Player player = new Player(playerRequest);

        return playerRepository.save(player);
    }

    public Player updatePlayer(long playerId, PlayerRequest playerRequest){
        if(playerRepository.existsById(playerId))
        {
            Player playerToBeUpdated = new Player(playerRequest);
            playerToBeUpdated.setId(playerId);
            return playerRepository.save(playerToBeUpdated);
        }
        else{
            throw new ResourceNotFound("player id not found");
        }
    }

    public void deletePlayer(long playerId){
        if(playerRepository.existsById(playerId)){
            playerRepository.deleteById(playerId);
        }
        else{
            throw new ResourceNotFound("player id not found");
        }
    }

    public Player addPlayerToTeam(long teamId, PlayerRequest playerRequest){
        Team team = teamRepository.findById(teamId).orElseThrow(()->new ResourceNotFound("team id not found"));

        Player playerToBeSaved = new Player(playerRequest);
        playerToBeSaved.setTeam(team);

        return playerRepository.save(playerToBeSaved);
    }

    public List<Player> getAllPlayersInTeam(long teamId){ return playerRepository.findAllByTeamId(teamId);}

    public List<Player> getPlayerByName(String userName){ return playerRepository.findAllByUserNameIgnoreCase(userName);}

    public void deleteAllByTeamId(long teamId){
        if(teamRepository.existsById(teamId)){
            playerRepository.deleteAllByTeamId(teamId);
        }
        else{
            throw new ResourceNotFound("player id not found");
        }
    }
}
