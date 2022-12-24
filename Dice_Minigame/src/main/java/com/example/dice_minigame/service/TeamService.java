package com.example.dice_minigame.service;

import com.example.dice_minigame.Entity.Achievements;
import com.example.dice_minigame.Entity.Player;
import com.example.dice_minigame.Entity.Team;
import com.example.dice_minigame.exception.ResourceNotFound;
import com.example.dice_minigame.repository.TeamRepository;
import com.example.dice_minigame.request.AchievementsRequest;
import com.example.dice_minigame.request.PlayerRequest;
import com.example.dice_minigame.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team getTeams(long teamId){
        Team team = teamRepository.findById(teamId).orElseThrow(()->new ResourceNotFound("team id not found"));
        return team;
    }

    public Team updateTeams(long teamId, TeamRequest teamRequest){
        if(teamRepository.existsById(teamId))
        {
            Team teamToBeUpdated = new Team(teamRequest);
            teamToBeUpdated.setId(teamId);
            return teamRepository.save(teamToBeUpdated);
        }
        else{
            throw new ResourceNotFound("team id not found");
        }
    }

    public void deleteTeam(long teamId){
        if(teamRepository.existsById(teamId)){
            teamRepository.deleteById(teamId);
        }
        else{
            throw new ResourceNotFound("team id not found");
        }
    }

    public Team addTeam(TeamRequest teamRequest)
    {
        Team team = new Team(teamRequest);

        return teamRepository.save(team);
    }

    public List<Team> getAllTeams(String teamNameParam){
        if(teamNameParam == null || teamNameParam.isEmpty())
            return (List<Team>) teamRepository.findAll();
        else {
            return (List<Team>) teamRepository.findAllByteamNameIgnoreCase(teamNameParam);
        }
    }
}
